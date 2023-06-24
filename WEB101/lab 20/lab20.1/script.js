"use strict";
function closeModal() {
  modal.classList.add("hidden");
  overlay.classList.add("hidden");
}
function showModel() {
  modal.classList.remove("hidden");
  overlay.classList.remove("hidden");
}
const modal = document.querySelector(".modal", "div");
const overlay = document.querySelector(".overlay");
const btnCloseModal = document.querySelector(".close-modal");
const btnsShowmodal = document.querySelectorAll(".show-modal");
//console.log(btnsShowmodal);

for (let i = 0; i < btnsShowmodal.length; i++) {
  btnsShowmodal[i].addEventListener("click", showModel);
}
// modal.style.display = "block";
// btnCloseModal.addEventListener("click", function () {
//   modal.classList.add("hidden");
// });
btnCloseModal.addEventListener("click", closeModal);

overlay.addEventListener("click", closeModal);

document.addEventListener("keydown", function (e) {
  if (!modal.classList.contains("hidden") && e.key === "Escape") {
    closeModal();
  }
});
