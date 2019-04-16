// - Get all posts
// - Get post with id of 10
// - Get the comments from post with id of 12 <br> *note: comments are part of a different data model, 
// - you'll need to structure your endpoint to ask for all of the comments that belong to post #12*
// - Get all the posts from user with id of 2
// - Create a new post and log the id generated for it by the server
// - Replace the post with id of 12 and render the responseJSON
// - Update the title of post with id of 12 and render responseJSON
// - Delete the post with id of 12 and render a success message
// - Display a list of posts.
//     - When the user clicks on a post, display all the comments from that post
//     - Display a link back to all posts

function parseObjects(data) {
    let objects = [];
    if (Array.isArray(data)){
        return data;
    } else {
        objects.push(data);
        return objects;
    }    
}

function appendData(objects,cssSelector) {
    if (typeof arguments[2] == 'undefined'){
        objects.forEach( (object) => {
            let HTMLelements = Object.keys(object).map( (key) => {
                return `<li>${key}: ${object[key]}</li>`;
            });
            let ul = document.createElement('ul');
            ul.innerHTML = HTMLelements.join('');
            $(cssSelector).append(ul);
        });
    } else {
        arguments[2](objects,cssSelector);
    } 
}

function GET(url,response) {
    $.get(url,response);
}

function POST(url,data) {
    $.post(url,data,function(returnData,status,xhr) {
        console.log(returnData.id);
    });
}

function PUT(url,data,success) {
    $.ajax(url, {
        data: data,
        method: 'PUT',
        success: success,
        error: function(xhr,status,error) {
            console.log(status,error);
        }
    });
}

function DELETE(url,success) {
    $.ajax(url, {
        method: 'DELETE',
        success: success,
        failure: function(xhr,status,error) {
            console.log('My Emporer: I FAILED YOU!!!');
        }
    })
}

function buildLists(data,status,xhr) {

    let objects = parseObjects(data);
    appendData(objects,'div#output'); 

}

function clearOutput() {
    $('div[id="output"]').empty();
}

$('input[value="all posts"]').on('click', (event) => {
    clearOutput();
    GET('https://jsonplaceholder.typicode.com/posts',buildLists);
});

$('input[value="id = 10"]').on('click',(event) => {
    clearOutput();
    GET('https://jsonplaceholder.typicode.com/posts?id=10',buildLists);
})

$('input[value="post 12 comments"]').on('click', (event) => {
    clearOutput();
    GET('https://jsonplaceholder.typicode.com/comments?postId=12',buildLists);    
})

$('input[value="userId = 2"]').on('click',(event) => {
    clearOutput();
    GET('https://jsonplaceholder.typicode.com/posts?userId=2',buildLists);
})

$('input[value="post new"]').on('click',(event) => {
    clearOutput();
    POST('https://jsonplaceholder.typicode.com/posts',{name:'Mike', message:'this is javascript'});
})

$('input[value="replace post 12"]').on('click',(event) => {
    clearOutput();
    PUT('https://jsonplaceholder.typicode.com/posts/12', 
    {name: 'Mike', message:"I'm the captain now"},
    (returnData) => {
        let objects = parseObjects(returnData);
        appendData(objects,'div#output');
    });
})

$('input[value="update post 12 title"]').on('click',(event) => {
    clearOutput();
    $.get('https://jsonplaceholder.typicode.com/posts?id=12', (data,status,xhr) => {
        objects = parseObjects(data);
        objects[0].title = 'New Title For A New Age';
        PUT('https://jsonplaceholder.typicode.com/posts/12',
        objects[0],
        (returnData) => {
            let objects = parseObjects(returnData);
            appendData(objects,'div#output');
        });
    });
});

$('input[value="delete post 12"]').on('click',(event) => {
    clearOutput();
    DELETE('https://jsonplaceholder.typicode.com/posts/12',
    (data,status,xhr) => {
        clearOutput();
        let m = document.createElement('p')
        m.textContent = status;
        $('div#output').append(m);
    });
});

$('input[value="posts and comments"]').on('click', (event)=> {
    clearOutput();
    GET('https://jsonplaceholder.typicode.com/posts', (data,status,xhr) => {
        let objects = parseObjects(data);
        appendData(objects,'div#output', (obj,css) => {
            obj.forEach( (object) => {
                let postId = '';
                let HTMLelements = Object.keys(object).map( (key) => {
                    if (key == 'id')
                        postId = object[key];
                    return `<li>${key}: ${object[key]}</li>`;
                });
                let ul = document.createElement('ul');
                ul.id = postId;
                ul.innerHTML = HTMLelements.join('');
                $(css).append(ul);
                let commentsDiv = document.createElement('div');
                commentsDiv.id = `comments${postId}`;
                $(css).append(commentsDiv);
                let commentsButton = document.createElement('input');
                commentsButton.type = 'button';
                commentsButton.value = 'comments';
                ul.appendChild(commentsButton);
                commentsButton.addEventListener('click', (event) => {
                    GET(`https://jsonplaceholder.typicode.com/comments?postId=${postId}`,
                        (data,status,xhr) => {
                            console.log($(`div#comments${postId}`).children())
                            if ($(`div#comments${postId}`).children().length == 0) {
                                let objects = parseObjects(data);
                                appendData(objects,`div#comments${postId}`, (obj,css) => {
                                    obj.forEach( (object) => {
                                        let HTMLelements = Object.keys(object).map( (key) => {
                                            return `<li>${key}: ${object[key]}</li>`;
                                        });
                                        let ul = document.createElement('ul');
                                        ul.innerHTML = HTMLelements.join('');
                                        $(css).append(ul);
                                    })
                                })
                            } else {//if the comment div is not empty
                                if ($(`div#comments${postId}`).css('display') == 'block') {
                                    $(`div#comments${postId}`).css('display','none');
                                } else {
                                    $(`div#comments${postId}`).css('display','block');
                                }
                            }
                            
                        });
                    
                });
            });
        });
    });
});
//GET('https://jsonplaceholder.typicode.com/posts'); //button 1;
//GET('https://jsonplaceholder.typicode.com/posts?id=10'); //button 2
//GET('https://jsonplaceholder.typicode.com/comments?postId=12'); // button 3
//GET('https://jsonplaceholder.typicode.com/posts?userId=2'); //button 4
//POST('https://jsonplaceholder.typicode.com/posts',{name:'Mike', message:'this is javascript'}); //button5


// PUT('https://jsonplaceholder.typicode.com/posts/12', 
//     {name: 'Mike', message:"I'm the captain now"},
//     (returnData) => {
//         let objects = parseObjects(returnData);
//         appendData(objects,'div#output');
//     }); // button 6


// PUT('https://jsonplaceholder.typicode.com/posts/12',
//     (() => {
//        GET('https://jsonplaceholder.typicode.com/posts?id=12');
//      })(),(returnData) => {
//         let objects = parseObjects(returnData);
//         appendData(objects,'div#output');
//      });

// $.get('https://jsonplaceholder.typicode.com/posts?id=12', (data,status,xhr) => {
//     objects = parseObjects(data);
//     objects[0].title = 'New Title For A New Age';
//     PUT('https://jsonplaceholder.typicode.com/posts/12',
//         objects[0],
//         (returnData) => {
//             let objects = parseObjects(returnData);
//             appendData(objects,'div#output');
//         });
// }); //button 7

// DELETE('https://jsonplaceholder.typicode.com/posts/12',
//     (data,status,xhr) => {
//         console.log("I'm here");
//         let m = document.createElement('p')
//         m.textContent = status;
//         $('div#output').append(m);
//     }); //button 8;

