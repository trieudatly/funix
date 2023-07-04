let title = document.querySelector("h1");
if (document.location.href.includes("project-pets")) {
  let all = document.querySelectorAll(".pets");
  title.innerHTML = "Project - PET WEB";
  all.forEach((item) => {
    item.style.display = "flex";
  });
} else if (document.location.href.includes("project-cv")) {
  let all = document.querySelectorAll(".cv");
  title.innerHTML = "Project - CV WEB";
  all.forEach((item) => {
    item.style.display = "flex";
  });
} else if (document.location.href.includes("project-news")) {
  let all = document.querySelectorAll(".news");
  title.innerHTML = "Project - NEWS WEB";
  all.forEach((item) => {
    item.style.display = "flex";
  });
}
