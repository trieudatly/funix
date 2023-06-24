'use strict';
//console.log(document.querySelector('.message').textContent);
// document.querySelector('.message').textContent = '🎉 Correct Number!';

// document.querySelector('.number').textContent = 13;
// document.querySelector('.score').textContent = 10;

// document.querySelector('.guess').value = 23;
// console.log(document.querySelector('.guess').value);
let secrecNumber = 0;
let score = 20;
let highScore = 0;

function secrecNumberInit() {
  secrecNumber = Math.trunc(Math.random() * 20) + 1;
  console.log(secrecNumber);
}
function gameLost() {
  document.querySelector('.message').textContent = '🎉 you lost the game';
  document.querySelector('.score').textContent = 0;
}
function displayMessage(message) {
  document.querySelector('.message').textContent = message;
}
secrecNumberInit();

document.querySelector('.check').addEventListener('click', function () {
  const guess = Number(document.querySelector('.guess').value);
  //console.log(guess);
  //when there is no input
  if (!guess) {
    //document.querySelector('.message').textContent = '⛔ No Number!';
    displayMessage('⛔ No Number!');
    //when player win
  } else if (guess === secrecNumber) {
    //document.querySelector('.message').textContent = '🎉 Correct Number!';
    displayMessage('🎉 Correct Number!');
    document.querySelector('body').style.backgroundColor = '#60b347';
    document.querySelector('.number').style.width = '30rem';
    document.querySelector('.number').textContent = secrecNumber;
    if (score > highScore) {
      highScore = score;
      document.querySelector('.highscore').textContent = highScore;
    }
    //when guess is wrong

    //when guess is too high
  } else if (guess !== secrecNumber) {
    if (score > 1) {
      //document.querySelector('.message').textContent = guess > secrecNumber ? '🤦‍♀️ too high!' : '🤦‍♀️ too low!';
      displayMessage(guess > secrecNumber ? '🤦‍♀️ too high!' : '🤦‍♀️ too low!');
      score--;
      document.querySelector('.score').textContent = score;
    } else {
      gameLost();
    }
    // } else if (guess > secrecNumber) {
    //   if (score > 1) {
    //     document.querySelector('.message').textContent = '🤦‍♀️ too high!';
    //     score--;
    //     document.querySelector('.score').textContent = score;
    //   } else {
    //     gameLost();
    //   } //when guess is too low
    // } else if (guess < secrecNumber) {
    //   if (score > 1) {
    //     document.querySelector('.message').textContent = '🤦‍♀️ too low!';
    //     score--;
    //     document.querySelector('.score').textContent = score;
    //   } else {
    //     gameLost();
    //   }
  }
});
document.querySelector('.again').addEventListener('click', function () {
  //document.querySelector('.message').textContent = 'Start guessing...';
  displayMessage('Start guessing...');
  document.querySelector('body').style.backgroundColor = '#222';
  document.querySelector('.number').style.width = '15rem';
  document.querySelector('.number').textContent = '?';
  secrecNumberInit();
  score = 20;
  document.querySelector('.score').textContent = score;
  document.querySelector('.guess').value = '';
});
