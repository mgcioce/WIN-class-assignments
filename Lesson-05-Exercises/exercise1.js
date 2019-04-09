// 1. Create an Array named `superHeroes`
// 	- Inside the superHeroes array create the following arrays: <br>

// 	```javascript
// 	["Batman", "Bruce Wayne"],
//    ["Spiderman", "Peter Parker"],
//    ["The Flash", "Barry Allen"]
//    ```
// 2. Create a `secretIdentity` variable
// 3. Assign `superHeroes.map()` to the `secretIdentity` variable
// 4. Assign and anonymous function to `superheroes.map()` as an argument
// 5. Your anonymous function should have one parameter named `revealArray`
// 6. Inside the block of your anonymous function:
// 	- You'll be working with revealArray as an argument
// 	- Using `revealArray` `return` a string that will `join` the two array items.
// 	- `join` them together with the string `"is"` <br> *ie: "Batman is Bruce Wayne"*
// 7. Log the results to the screen and `join` them with a line break.

let superHeroes = [["Batman","Bruce Wayne"], ["Spiderman","Peter Parker"], ["The Flash","Barry Allen"]];
let secretIdentity = superHeroes.map((hero) => {
    return `${hero[0]} is ${hero[1]}`;
});
secretIdentity.forEach( (e) => {
    console.log(e);
});