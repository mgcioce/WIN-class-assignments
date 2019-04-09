// - Find a player with the name 'Mike'
// - Get an array of all players with position 'RB'
// - Get an array of all the players lastNames
// - Get an array of the full names of all the runningbacks with more than 5 touchdowns
// - Get the number of touchdowns scored by Runningbacks

const players = [
	{firstName: 'Cam', lastName: 'Newton', position: 'QB', touchdowns: 32},
	{firstName: 'Derek', lastName: 'Anderson', position: 'QB', touchdowns: 0},
	{firstName: 'Jonathan', lastName: 'Stewart', position: 'RB', touchdowns: 12},
	{firstName: 'Mike', lastName: 'Tolbert', position: 'RB', touchdowns: 8},
	{firstName: 'Fozzy', lastName: 'Whittaker', position: 'RB', touchdowns: 3},
	{firstName: 'Ted', lastName: 'Ginn', position: 'WR', touchdowns: 9},
	{firstName: 'Devin', lastName: 'Funchess', position: 'WR', touchdowns: 2}
];

let playerNamedMike = players.find( (player) => {
    return player.firstName == "Mike";
})
console.log(playerNamedMike);

let RBs = players.filter( (player) => {
    return player.position == "RB";
})
console.log(RBs);

let lastNames = players.map( (player) => {
    return player.lastName;
})
console.log(lastNames);

let RBsWithSixPlusTDs = RBs.filter( (player) => {
    return player.touchdowns > 5;
}).map( (player) => {
    return `${player.firstName} ${player.lastName}`;
})
console.log(RBsWithSixPlusTDs);

let TDsByRBs = RBs.reduce((accumulator,nextPlayer) => {
    return accumulator + nextPlayer.touchdowns;
},0);
console.log(TDsByRBs);

