// Using jQuery:

// - Load jQuery (using a CDN)
// - Get the top-level header element
// - Get all the section elements
// - Get the section element with class="current"
// - Get the section that comes after the current section
// - Get the h2 node from the section before the 'current' section
// - Get the div that contains the section that has an h2 with a class of 'highlight'
// - Get all the sections that contain an H2 and store them in an Array

let header = $('header');
console.log(header);
let sections = $('section');
console.log(sections);
let currentSection = $('section.current');
console.log(currentSection);
let sectionAfterCurrent = currentSection.next('section');
console.log(sectionAfterCurrent);
let h2 = currentSection.prev('section').find('h2');
console.log(h2);
let div = $('div').has('section>h2.highlight');
console.log(div);
let h2s = sections.has('h2');
console.log(h2s.toArray());




