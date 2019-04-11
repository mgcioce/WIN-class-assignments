// 1. Update the 'Coffee' item to say 'Fair Trade Coffee'
// 2. Remove 'Twinkies' from the list
// 3. Add an item 'Cheese Whiz'
// 4. Clear the list and programmatically add items from the array `['protein powder', 'muscle milk', 'power bars']`
// 5. Add the class 'important' to the muscle milk item.
let lis = document.querySelectorAll('li');
lis.forEach( (node) => {
    if (node.textContent == 'Coffee'){
        node.textContent = 'Fair Trade Coffee'
    }
    if (node.textContent == 'Twinkies') {
        node.remove();
    }
});
const ul = document.querySelector('ul');
console.log(ul.childNodes);
const cheeseWhiz = document.createElement('li');
cheeseWhiz.textContent = `Cheese Whiz`;
ul.appendChild(cheeseWhiz);
lis = document.querySelectorAll('li');
lis.forEach( (node) => {
    node.remove();
})
let array = ['protein powder', 'muscle milk', 'power bars'];
array.forEach( (text) => {
    let newElement = document.createElement('li');
    newElement.textContent = text;
    if (text == 'muscle milk') {
        newElement.className = 'important';
    }
    ul.appendChild(newElement);
});

function (text) {
    
}



