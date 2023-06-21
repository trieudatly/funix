let js = "amazing";
//if (js == "amazing") alert("javascript is fun");
// console.log(40 + 8 + 23 - 10);

// let age = 30;
// age = 31;
// const birthYear = 1991;
// // birthYear = 1990;
// // const job;
// var job = "programmer";
// job = "teacher";

// lastName = "dat";
// console.log(lastName);

// const now = 2037;
// const ageJonas = now - 1991;
// const ageSarah = now - 2018;
// console.log(ageJonas, ageSarah);
// console.log(now - 1991 > now - 2018);

// let x, y;
// x = y = 25 - 10 - 5;
// console.log(x, y);

// const firstName = "jonas";
// const job = "teacher";
// const birthYear = 1991;
// const year = 2037;
// const jonas =
//   "I'm " + firstName + ", a " + (year - birthYear) + " year old " + job + "!";
// console.log(jonas);
// const jonasNew = `I'm ${firstName}, a ${year - birthYear} year old ${job}!`;
// console.log(jonasNew);
// console.log(`just a regular string....`);
// console.log(
//   "String with \n\
// multiple \n\
// lines"
// );
// console.log(`String
// with
// multiple
// lines`);

const age = 16;
const isOldEnough = age >= 18;

// if (isOldEnough) {
//   console.log("Sarah can start driving licence 🚗");
// }
if (age >= 18) {
  console.log("Sarah can start driving licence 🚗");
} else {
  console.log(`Sarah is too young. Wait another ${18 - age} years`);
}

const birthYear = 2009;
let century;
if (birthYear <= 2000) {
  century = 20;
} else {
  century = 21;
}
console.log(century);
