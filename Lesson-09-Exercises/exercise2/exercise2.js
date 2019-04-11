// - Create a function that will fire when the **submit** `<button>` is *clicked*
// - Make sure the function loaded after the `DOM`
// - Inside the function:
// 	- create variables for each of the form inputs
// 		- use jQuery to accomplish this task
// 		- *(think about querySelector)*
// 	- create an `array` named *required*
// 		- store the variables you've **name**, **email**, and **phone number**
// 	- Utilize a `for` loop to iterate of the entire **required** `array`
// 	- Inside the `for` loop:
// 		- use an `if` statement to check the **value** of each array item
// 		- **if** the array item is equal to an empty string (`""`)
// 			- populate the `message` `<p>` with the following text: <br> *"Please Fill Out Required Fields"*
// 			-  add the **warning** `class` to this message
// 		- Attach the **warning** `class` to the array item's `<label>` <br> *note: You want the label to turn red, if the field is empty*
// 		- once the field has something *other* than a blank string. make sure the **warning** `class` is removed
// 	- close out the `for` loop
// 	- utilize another `if` statement
// 		- verify that no `<label>`'s have the **warning** `class`
// 		- if true
// 			- remove the `form` from the `DOM`
// 			- manipulate the `<h2>` to say: *"Thanks for your feedback!"*
// - close out your function
// - test it out!

$.ready( $('input#submit').click(function(event) {
    let form = $('form');
    let formElements = form.children();
    let nodeArray = [];
    
    formElements.each( function(index,element) {
        if (element.hasAttribute('placeholder')){
            nodeArray.push(element);
        }
    });

    let failure = false;
    let warningTest = (node) => {
        if (node.value == '') {
            failure = true;
            node.setAttribute('class','warning');
            return true;    
        }
        node.setAttribute('class',null);
        return false;
    }
    nodeArray.forEach(warningTest);


    if (failure) {
        $('p#message').text("Please fill out the highlighted boxes and submit again");
    } else {
        form.remove();
        $('div#pre-form>h2').text("Thanks for your feedback!");    
    }
}))

