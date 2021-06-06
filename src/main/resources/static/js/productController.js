//Doing a Product web app, in product page to
//display the name, description, imageUrl, style, price, ..., ...,.....,....

const createHTMLList = (title, description, date) =>
  `
          <tr>
            <td>${title}</td>
            <td>${description}</td>
            <td>${date}</td>
          </tr>
`;

class ProductsController {
  constructor() {
    this._items = []; //create an array to store the details of product items
  }

  //    method to add the items into the array
  addItem(title, description, date) {
    var productController = this;

    const item = {
      title: title,
      description: description,
      date: date,
    };

    //Push the item to the items property
    //productController._items.push(item);
    const formData = new FormData();
    formData.append("title", title);
    formData.append("description", description);
    formData.append("date", date);

    for (var pair of formData.entries()) {
      console.log(pair[0] + ", " + pair[1]);
    }

    fetch("http://127.0.0.1:8080/item/add", {
      method: "POST", // or 'PUT'
      body: formData,
    })
      .then((response) => response.json())
      .then((data) => {
        console.log("Success:", data);
        alert("Successfully added to Product");
      })

      .catch((error) => {
        console.error("Error:", error);
        alert("Error adding item to Product");
      });
  }
  displayItem() {
    //fetch data from database using the REST API endpoint from Spring Boot
    var productController = this;
    productController._items = [];

    fetch("http://127.0.0.1:8080/item/all")
      .then((resp) => resp.json())
      .then(function (data) {
        console.log("2. receive data");
        console.log(data);

        data.forEach(function (item, index) {
          const itemObj = {
            oId: item.id,
            oTitle: item.title,
            oDescription: item.description,
            oDate: item.date,
          };
          productController._items.push(itemObj);
        });
        productController.render();
      })

      .catch(function (error) {
        console.log(error);
      });
  }

  render() {
    var productController = this;
    const productHTMLList = [];

    //Display products after getting from the database
    for (var i = 0; i < productController._items.length; i++) {
      const item = productController._items[i]; //assign the individual item to the variable
      const productHTML = createHTMLList(
        item.oTitle,
        item.oDescription,
        item.oDate
      );
      productHTMLList.push(productHTML);
    }

    //Join all the elements/items in my productHTMLList array into one string, and seperate by a break
    const pHTML = productHTMLList.join("\n");
    const itemsContainer = document.querySelector(".table-body");
    itemsContainer.innerHTML = pHTML;
  }
} //End of ProductsController class
