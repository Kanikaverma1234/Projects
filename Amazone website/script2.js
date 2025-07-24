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