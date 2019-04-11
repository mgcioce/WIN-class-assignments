// - Show an unordered list of todo's
// - Show an input to enter a new todo
// - Show a button to add a todo. When the button is clicked:
// 	- The text from the input box is used to add a list item to the bottom of the list
// 	- The text from the input box is cleared out.
// - When the user clicks on a list item, it is removed
// - **Extra Credit:** - When a list item is clicked, cross it out, then remove it after 1 second.

const ul = $('ul'); //grabs unordered list element 
const toDoEnter = $('input'); //grabs input element

toDoEnter.on('keypress', (event) => { //create an event for keypress in the textbox
    if (event.keyCode == 13) {  //if the keypress was the enter key
        let newToDo = `<li>${toDoEnter.val()}</li>` //build htmlString
        
        // let newToDo = document.createElement('li');
        // newToDo.textContent = toDoEnter[0].value;
        ul.append(newToDo); //append html to ul as a child using htmlString to build element
        toDoEnter.val(''); //change the value of the text box to an empty string
        let listElements = ul.children(); //get the jquery object of html elements that are children of
                                            // the ul element in the DOM tree
        // toDoEnter.value = '';
        // let listElements = ul.childNodes;
        listElements.each( (integer,node) => { // do a for-each loop for every html element in the 
                                                //jquery object
            node.addEventListener('click', (event) => {
                node.style = 'text-decoration: line-through';
                setTimeout(() => {
                    node.remove();
                },1000);
            })
        })
    }
});

// listElements.forEach( (node) => {
//     node.addEventListener('click', (event) => {
//         console.log("I work");
//         node.style = 'text-decoration: line-through';
//     })
// })