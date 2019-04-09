// 1. An array called `photoList` that contains the names of the photos as strings
// 2. An integer `currentPhotoIndex` that represents which photo in the `photoList` is currently displayed
// 3. A `nextPhoto()` function that moves `currentPhotoIndex` to the next index `if `there is one, and:
// 	4. logs the current photo name.
// 	4. Otherwise, log "End of slideshow";
// 4. A `prevPhoto()` function that does the same thing, but backwards.
// 5. A function `getCurrentPhoto()` that returns the current photo from the list.

let slideShow = {
    photoList: [],
    currentPhotoIndex: 0,
    nextPhoto: function(){
        if (this.currentPhotoIndex == this.photoList.length - 1) {
            this.currentPhotoIndex = 0;
            console.log("End of slideshow");
        } else {
            console.log(this.photoList[++this.currentPhotoIndex]);
        }
    },
    prevPhoto: function(){
        if (this.currentPhotoIndex == 0) {
            console.log("beginning of slideshow");
        } else {
            console.log(this.photoList[--this.currentPhotoIndex]);
        }
    },
    getCurrentPhoto: function() {
        return this.photoList[this.currentPhotoIndex];
    }

}