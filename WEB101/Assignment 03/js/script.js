function handleSubmit() {
  //lấy giá trị input email và chuyển sang in thường
  const emailValue = document.getElementById("email").value.toLowerCase();
  //lấy element của thẻ p hiển thị lỗi
  const errorEmail = document.getElementById("error-email");
  //điều kiện dể là một email hợp lệ
  const emailRegex =
    /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  //dùng match để kiểm tra email vừa nhập
  const check = emailValue.match(emailRegex);
  //lấy phần thông tin user
  /** @type {HTMLDivElement} */
  const sectionContent = document.querySelector("#info .section-content");
  //lấy element để kiểm soát submit
  const submitControl = document.querySelector(".submit-email");
  if (check) {
    sectionContent.style.display = "block";
    submitControl.style.display = "none";
    errorEmail.innerHTML = "";
  } else {
    errorEmail.innerHTML = "Vui lòng nhập đúng định dạng email";
  }
}

function handleOnMouseOver(element) {
  const viewMore = element.querySelector(".view-more");
  viewMore.style.display = "inline-block";
}
function handleOnMouseOut(element) {
  const viewMore = element.querySelector(".view-more");
  viewMore.style.display = "none";
}
function handleViewMore(element) {
  const view = element.parentNode.parentNode.querySelector(".view");
  if (view.style.display == "none") {
    view.style.display = "block";
    element.innerText = "View less";
  } else {
    view.style.display = "none";
    element.innerText = "View more";
  }
}
