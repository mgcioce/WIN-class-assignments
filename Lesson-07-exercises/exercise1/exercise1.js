//Button elements
const rock = document.querySelector('input[value="Rock"]');
const paper = document.querySelector('input[value="Paper"]');
const scissors = document.querySelector('input[value="Scissors"]');
//output text elements
const result = document.querySelector('p[id="resultText"]');
const winner = document.querySelector('h1[id="winnerText"]');
const playAgain = document.querySelector('input[value="Play Again?"]')
//object definition and creation
class Player {
    constructor(name) {
        this.name = name;
        this.hand = null;
        this.wins = 0;
        this.hands = ["Rock","Paper","Scissors"];
    }
    getHand(choice) {
        if (typeof choice === 'undefined') {
            let random = Math.floor(Math.random() * 3);
            this.hand = this.hands[random];
        } else {
            this.hand = choice;
        }
    }
}
const CPU = new Player("I");
const player1 = new Player("You");
//function definitions
function outputResults(resultText) {
    result.innerHTML = resultText;
}

function resolve(p1,p2) {
    let resultText = `${p1.name} picked ${p1.hand}: ${p2.name} picked ${p2.hand}: `
    if (p1.hand == p2.hand) {
        return outputResults(resultText + `it's a draw`);
    }
    let winningConditions = {
        Rock: "Scissors",
        Paper: "Rock",
        Scissors: "Paper"
    }
    if (winningConditions[p1.hand] == CPU.hand) {
        p1.wins++;
        outputResults(resultText + `${p1.name} win`);
    } else {
        p2.wins++;
        outputResults(resultText + `${p2.name} win`);
    }
}

function pickWinner(p1,p2) {
    if (p1.wins == 3 || p2.wins == 3) {
        if (p1.wins > p2.wins) {
            winner.innerHTML = "You Win!";
        } else {
            winner.innerHTML = "I Win!";
        }
        playAgain.style.display = 'block';
    }
}
//button presses
rock.addEventListener('click', (event) => {
    player1.getHand("Rock");
    CPU.getHand();
    resolve(player1,CPU);
    pickWinner(player1,CPU);
});
paper.addEventListener('click', (event) => {
    player1.getHand("Paper");
    CPU.getHand();
    resolve(player1,CPU);
    pickWinner(player1,CPU);
});
scissors.addEventListener('click', (event) => {
    player1.getHand("Scissors");
    CPU.getHand();
    resolve(player1,CPU);
    pickWinner(player1,CPU);
});
playAgain.addEventListener('click', (event) => {
    window.location.reload(false);
})






