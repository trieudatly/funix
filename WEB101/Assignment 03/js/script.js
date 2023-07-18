function handleSubmit() {
  //lấy giá trị input email và chuyển sang in thường
  const emailValue = document.getElementById("email").value.toLowerCase();
  //lấy element của thẻ p hiển thị lỗi
  const errorEmail = document.getElementById("error-email");
  //điều kiện để là một email hợp lệ
  const emailRegex =
    /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  //dùng match để kiểm tra email vừa nhập
  const check = emailValue.match(emailRegex);
  //lấy phần thông tin user
  /** @type {HTMLDivElement} */
  const sectionContent = document.querySelector("#info .section-content");
  //lấy element để kiểm soát submit
  const submitControl = document.querySelector(".submit-email");
  //kiểm tra nếu email hợp lệ
  if (check) {
    //đổi style display của thông tin user thành "block"
    sectionContent.style.display = "block";
    //ẩn nút submit
    submitControl.style.display = "none";
    //xóa thông báo lỗi
    errorEmail.innerHTML = "";
  } else {
    //đổi nội dung thông báo lỗi
    errorEmail.innerHTML = "Vui lòng nhập đúng định dạng email";
  }
}
//khi người dùng đưa trỏ chuột lên card
function handleOnMouseOver(element) {
  //lấy element để kiểm soát nút ".view-more"
  const viewMore = element.querySelector(".view-more");
  //đổi style display của thông tin user thành "inline-block", hiện nút view more
  viewMore.style.display = "inline-block";
}
//khi người dùng đưa trỏ chuột ra khỏi card
function handleOnMouseOut(element) {
  const viewMore = element.querySelector(".view-more");
  //đổi style display của thông tin user thành "none", ẩn nút view more
  viewMore.style.display = "none";
}

// khi người dùng click nút "view more"
function handleViewMore(element) {
  //lấy element để kiểm soát class ".card-text"
  const view = element.parentNode.parentNode.querySelector(".card-text");
  //nếu style display của ".card-text" là "none", tức là đang ẩn
  console.log(view.style.display);
  if (view.style.display == "none" || !view.style.display) {
    //đổi style display thành "block", hiện thông tin cá nhân
    view.style.display = "block";
    //đổi văn bản nút view more thành view less
    element.innerText = "View less";
  } else {
    //nếu style display của ".card-text" khác "none", tức là đang hiển thị
    //đổi style display thành "none", ẩn thông tin cá nhân
    view.style.display = "none";
    //đổi văn bản nút view less thành view more
    element.innerText = "View more";
  }
}
