//kiểm tra nếu nội dung url có bao gồm "project-pets"
if (document.location.href.includes("project-pets")) {
  //nếu có
  //lấy tất cả element của thẻ có class ".pets"
  let all = document.querySelectorAll(".pets");
  //đổi web title thành "Project - PET WEB"
  document.title = "Project - PET WEB";
  //đổi style display tất cả các thẻ có class ".pets" thành "block"
  all.forEach((item) => {
    item.style.display = "block";
  }); //nếu không
  //kiểm tra với "project-cv"
} else if (document.location.href.includes("project-cv")) {
  let all = document.querySelectorAll(".cv");
  document.title = "Project - CV WEB";
  all.forEach((item) => {
    item.style.display = "block";
  });
  //kiểm tra với "project-news"
} else if (document.location.href.includes("project-news")) {
  let all = document.querySelectorAll(".news");
  document.title = "Project - NEWS WEB";
  all.forEach((item) => {
    item.style.display = "block";
  });
}
