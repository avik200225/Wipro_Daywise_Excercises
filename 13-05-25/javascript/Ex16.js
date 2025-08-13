const images = [
    "https://images.pexels.com/photos/158063/bellingrath-gardens-alabama-landscape-scenic-158063.jpeg",
    "https://images.pexels.com/photos/247599/pexels-photo-247599.jpeg",
    "https://images.pexels.com/photos/250591/pexels-photo-250591.jpeg",
    "https://images.pexels.com/photos/39517/rose-flower-blossom-bloom-39517.jpeg"
];


let currentIndex = 0;
const galleryImage = document.getElementById("galleryImage");

function showImage() {
    galleryImage.src = images[currentIndex];
}

function prevImage() {
    currentIndex--;
    if (currentIndex < 0) {
        currentIndex = images.length - 1;
    }
    galleryImage.src = images[currentIndex];
}

function nextImage() {
    currentIndex++;
    if (currentIndex >= images.length) {
        currentIndex = 0;
    }
    galleryImage.src = images[currentIndex];
}

document.getElementById("prevBtn").onclick = prevImage;
document.getElementById("nextBtn").onclick = nextImage;

showImage();