// 1. Get the header element
// 2. Get all the section elements
// 3. Get the section element with class="current"
// 4. Get the section that comes after the current section
// 5. Get the h2 node from the section before the 'current' section
// 6. Get the div that contains the section that has an h2 with a class of 'highlight'
// 8. Get all the sections that contain an H2 (using a single statement);

const header = document.querySelector('header');
console.log(header);
const sections = document.querySelectorAll('section');
console.log(sections);
const sectionCurrent = document.querySelector('section[class="current"]');
console.log(sectionCurrent);
const sectionAfterCurrent = sectionCurrent.nextSibling.nextSibling;
console.log(sectionAfterCurrent);
const h2 = sectionCurrent.previousSibling.previousSibling.firstChild.nextSibling;
console.log(h2);
const div = document.querySelector('h2[class=highlight]').parentNode.parentNode;
console.log(div);
const h2s = document.querySelectorAll('h2');
console.log(h2s);