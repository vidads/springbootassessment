$(function () {
  $(document).ready(function () {
    var todaysDate = new Date(); // Gets today's date

    // Max date attribute is in "YYYY-MM-DD".  Need to format today's date accordingly

    var year = todaysDate.getFullYear(); // YYYY

    var month = ("0" + (todaysDate.getMonth() + 1)).slice(-2); // MM

    var day = ("0" + todaysDate.getDate()).slice(-2); // DD

    var minDate = year + "-" + month + "-" + day; // Results in "YYYY-MM-DD" for today's date

    // Now to set the max date value for the calendar to be today's date

    $("#newItemDate").attr("min", minDate);
  });
});

// $(function () {
//   $("#newItemDate").newItemDate({
//     dateFormat: "dd/mm/yy",
//     changeMonth: true,
//     changeYear: true,
//   });
// });

const productsControl = new ProductsController();

//
//
newItemForm.addEventListener("submit", (event) => {
  //
  event.preventDefault();
  //
  const newItemTitleInput = document.querySelector("#newItemTitleInput");
  const newItemDescription = document.querySelector("#newItemDescription");
  const newItemDate = document.querySelector("#newItemDate");
  console.log(newItemDate);
  const newDate = newItemDate.value.split("-").reverse().join("/");
  console.log(newDate);

  /*
        Do validation code here
    */

  //
  const title = newItemTitleInput.value;
  const description = newItemDescription.value;

  //Clear the form
  newItemTitleInput.value = "";
  newItemDescription.value = "";
  newItemDate.value = "";

  //Add the task to the task manager
  productsControl.addItem(title, description, newDate);
});
