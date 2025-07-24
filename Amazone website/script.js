const imgs = document.querySelectorAll(".header-slider ul img");
const prev_btn = document.querySelector(".ctr-prev");
const next_btn = document.querySelector(".ctr-next");


let n = 0;
function changeSlider() {
    for (let i = 0; i < imgs.length; i++) {
        imgs[i].style.display = "none"
    }
    imgs[n].style.display = "block"

} changeSlider();

prev_btn.addEventListener("click", () => {
    if (n > 0) {
        n--;
    } else {
        n = imgs.length - 1
    }
    changeSlider();
})
next_btn.addEventListener("click", (e) => {
    if (n < imgs.length - 1) {
        n++;
    } else {
        n = 0;
    }
    changeSlider();
})

// slidebar-container-navigation

const sidebarNavigationEl = document.getElementById("sidebar-container-navigation");
const sidebarOpenNavigationEl = document.getElementById("open-nav-slider");
const sidebarCloseNavigationEl = document.getElementById("sidebar-navigation-close")

sidebarOpenNavigationEl.addEventListener("click", () => {
    sidebarNavigationEl.classList.toggle("sidebar-show");
    document.body.style.overflow = "hidden"
})
sidebarCloseNavigationEl.addEventListener("click", () => {
    sidebarNavigationEl.classList.toggle("sidebar-show");
    document.body.style.overflow = "";

})