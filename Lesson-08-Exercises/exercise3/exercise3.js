// - Show an unordered list of todo's
// - Show an input to enter a new todo
// - Show a button to add a todo. When the button is clicked:
// 	- The text from the input box is used to add a list item to the bottom of the list
// 	- The text from the input box is cleared out.
// - When the user clicks on a list item, it is removed
// - **Extra Credit:** - When a list item is clicked, cross it out, then remove it after 1 second.

const ul = document.querySelector('ul');
const toDoEnter = document.querySelector('input');

toDoEnter.addEventListener('keypress', (event) => {
    if (event.keyCode == 13) {
        let newToDo = document.createElement('li');
        newToDo.textContent = toDoEnter.value;
        ul.appendChild(newToDo);
        toDoEnter.value = '';
        let listElements = ul.childNodes;
        listElements.forEach( (node) => {
            node.addEventListener('click', (event) => {
                console.log("I work");
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