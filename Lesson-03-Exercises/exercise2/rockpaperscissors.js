let hands = ['rock','paper','scissors'];

function getHand(hands) {
    let index = null;
    index = Math.floor(Math.random() * 3);
    return hands[index];
}

class Player {

    constructor(name,getHand) {
        this.name = name;
        this.getHand = getHand;
        this.hand = null;
        this.wins = 0;
        this.nextRound = false;
    }
}

let player1 = {
    name: null,
    getHand: getHand,
    hand: null,
    wins: 0,
    nextRound: false,
}

let player2 = {
    name: null,
    getHand: getHand,
    hand: null,
    wins: 0,
    nextRound: false
}

let winningConditions = {
    rock: 'scissors',
    paper: 'rock',
    scissors: 'paper'  
}

function playRound(player1,player2,hands,winningConditions) {
    player1.hand = player1.getHand(hands);
    player2.hand = player2.getHand(hands);
    if (player1.hand == player2.hand) {
        console.log("it's a tie");
        return null;
    } else {
        if (winningConditions[player1.hand] == player2.hand) {
            console.log("player1 wins");
            return player1;
        } else {
            console.log("player2 wins");
            return player2;
        }
    }
}

function addWins(player) {
    if (player !== null)
        player.wins++;
}

function playGame(player1,player2,hands,winningConditions,playUntil) {
    while(player1.wins < playUntil && player2.wins < playUntil) {
        addWins(playRound(player1,player2,hands,winningConditions));
    }
    if (player1.wins == playUntil) {
        console.log("player1 wins");
        return player1;
    } else {
        console.log("player2 wins!");
        return player2;
    }
}

// function buildTree(n) {

// }

// function buildBracket(playerArray) {
//     buildTree(playerArray.length);
// }

// function tournament(numOfEntrants,getHand,hands,winningConditions,playUntil) {
//     let players = [];
//     for (let i = 0; i < numOfEntrants; i++) {
//         players.push(new Player("player" + (i+1),getHand));
//     }
//     let bracket = buildBracket(players);
//     console.log(players);
// }


// //playGame(player1,player2,hands,winningConditions,5);
// tournament(4,getHand,hands,winningConditions,5);
