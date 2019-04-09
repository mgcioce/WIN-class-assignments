// - Create a user profile object that contains properties for
// 	- name
// 	- address
// 	- city
// 	- state
// 	- zipcode
// 	- avatar
// - Write a function `getProfileUpdate()` that changes something about the current profile. 
// - For now, just hard code the return value. *Unless you're brave enough to get user input.*
// - Write a function `updateProfile()` that takes a single object of keys:values and overwrites 
// - those keys on the profile object
// - Get a profile update and update the profile with it.
// - log the new profile

class Profile{
    constructor(firstName,lastName,address,city,state,zipcode,avatar) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.avatar = avatar;
    }
}

const submitButton = document.querySelector('input[value="Submit"]');
const userForm = document.querySelector('form[id="userForm"]');
let userInput = [];
submitButton.addEventListener('click', (event) => {
    let inputData = userForm.childNodes;
    inputData.forEach((data) => {
        if (typeof data.value != "undefined" && data.value != "Submit") {
            userInput.push(data.value);
        }     
    });
    console.log(new Profile(userInput[0],userInput[1],userInput[2],userInput[3],userInput[4],
                userInput[5],userInput[6]));
})



