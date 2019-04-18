//let students = ['a','b','c'];
//let [x,...z] = students;
//console.log(x,...z);

// let completedHomework = () => {
//     return ['a','b','c'];
// }
// let [x,y,z] = completedHomework();
// console.log(x,y,z);

function returnBothThings() {
    let myObject = {
        me: 'Mike',
        notMe: 'Bruice',
    }
    
    function thisFunk(newNotMe = 'somebody') {
        return newNotMe;
    }
    return [myObject,thisFunk];
}



