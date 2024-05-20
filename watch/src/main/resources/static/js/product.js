// Read Modal
document.addEventListener('DOMContentLoaded', function () {
    // Get all 'view-product' links
    const viewProductDetails = document.querySelectorAll('.view-product');

    // Add click event listeners to each link
    viewProductDetails.forEach(link => {
        link.addEventListener('click', function (event) {
            event.preventDefault(); // Prevent the link from navigating

            // Extract data attributes from the clicked link
            const id = this.getAttribute('data-id');

            // Fetch product details from server
            fetch(`/api/product/view/${id}`)
                .then(response => response.json())
                .then(data => {

                    // Update product information in the modal
                    document.getElementById('imgUrl').textContent = data.imgUrl;
                    document.getElementById('dialColor').textContent = data.dialColor;
                    document.getElementById('caseMaterial').textContent = data.caseMaterial;
                    document.getElementById('strapMaterial').textContent = data.strapMaterial;
                    document.getElementById('movementType').textContent = data.movementType;
                    document.getElementById('waterResistance').textContent = data.waterResistance;
                    document.getElementById('caseDiameter').textContent = data.caseDiameter;
                    document.getElementById('caseThickness').textContent = data.caseThickness;
                    document.getElementById('powerReserve').textContent = data.powerReserve;


                    // Check if data.reviews is defined before attempting to iterate over it
                    if (data.reviews) {
                        // Proceed with processing product details
                        const reviewDetails = document.getElementById('reviewDetails');
                        reviewDetails.innerHTML = ''; // Clear previous entries

                        data.reviews.forEach(detail => {
                            const row = `<tr>
                                            <td class="align-middle text-center">${detail.id}</td>
                                            <td class="align-middle text-center">${detail.rating}</td>
                                            <td class="align-middle text-center">${detail.comment}</td>
                                            <td class="align-middle text-center">${detail.createdAt}</td>
                                        </tr>`;
                            reviewDetails.innerHTML += row;
                        });
                    } else {
                        // Handle case where product details are not available
                        console.error('Error: No product details found in the response.');
                    }



                    // Show the modal
                    const productDetailsModal = new bootstrap.Modal(document.getElementById('productDetails'));
                    productDetailsModal.show();
                })
                .catch(error => console.error('Error loading the product details:', error));
        });
    });
});
// Read Modal

// Update Modal
// Function to handle the click event on the update-product link
document.querySelectorAll('.update-product').forEach(link => {
    link.addEventListener('click', function (event) {
        event.preventDefault(); // Prevent the default link behavior

        // Extract data attributes from the clicked link
        const id = this.getAttribute('data-id');

        // Fetch product details from server
        fetch(`/api/product/view/${id}`)
            .then(response => response.json())
            .then(data => {

                // Fill the modal form with product data
                document.getElementById('idEditProduct').value = data.id;
                document.getElementById('nameEditProduct').value = data.name;
                document.getElementById('descriptionEditProduct').value = data.description;
                document.getElementById('brandEditProduct').value = data.brand;
                document.getElementById('imgUrlEditProduct').value = data.imgUrl;
                document.getElementById('dialColorEditProduct').value = data.dialColor;
                document.getElementById('priceEditProduct').value = data.price;
                document.getElementById('soldEditProduct').value = data.sold;

                document.getElementById('caseMaterialEditProduct').value = data.caseMaterial;
                document.getElementById('strapMaterialEditProduct').value = data.strapMaterial;
                document.getElementById('movementTypeEditProduct').value = data.movementType;
                document.getElementById('waterResistanceEditProduct').value = data.waterResistance;
                document.getElementById('caseDiameterEditProduct').value = data.caseDiameter;
                document.getElementById('caseThicknessEditProduct').value = data.caseThickness;
                document.getElementById('powerReserveEditProduct').value = data.powerReserve;

                // Show the modal
                const productUpdateModal = new bootstrap.Modal(document.getElementById('editProduct'));
                productUpdateModal.show();
            })
            .catch(error => console.error('Error loading the product details:', error));
    });
});

// Function to handle the click event on the "Save" button in the modal
document.getElementById('saveProductChanges').addEventListener('click', function (event) {
    // Get updated product data from the modal form
    const id = document.getElementById('idEditProduct').value;
    const name = document.getElementById('nameEditProduct').value;
    const description =  document.getElementById('descriptionEditProduct').value;
    const brand = document.getElementById('brandEditProduct').value;
    const imgUrl = document.getElementById('imgUrlEditProduct').value;
    const dialColor = document.getElementById('dialColorEditProduct').value;
    const price = document.getElementById('priceEditProduct').value;
    const sold = document.getElementById('soldEditProduct').value;
    const caseMaterial = document.getElementById('caseMaterialEditProduct').value;
    const strapMaterial = document.getElementById('strapMaterialEditProduct').value;
    const movementType = document.getElementById('movementTypeEditProduct').value;
    const waterResistance = document.getElementById('waterResistanceEditProduct').value;
    const caseDiameter = document.getElementById('caseDiameterEditProduct').value;
    const caseThickness = document.getElementById('caseThicknessEditProduct').value;
    const powerReserve = document.getElementById('powerReserveEditProduct').value;


    // Create an object with the updated data
    const updatedProduct = {
        id: id,
        name: name,
        description: description,
        brand: brand,
        imgUrl: imgUrl,
        dialColor: dialColor,
        price: price,
        sold: sold,
        caseMaterial: caseMaterial,
        strapMaterial: strapMaterial,
        movementType: movementType,
        waterResistance: waterResistance,
        caseDiameter: caseDiameter,
        caseThickness: caseThickness,
        powerReserve: powerReserve
    };

    // Here you can send the updated data to the backend using AJAX
    fetch('/api/product/update', {
        method: 'POST',
        body: JSON.stringify(updatedProduct),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => {
        // Handle response
        if (response.ok) {
            return response.json();
        }
        throw new Error('Network response was not ok.');
    }).then(data => {
        console.log('Product updated successfully:', data);
        // Hide the modal
        $('#editProduct').modal('hide');
        // Reload the page
        location.reload();
    }).catch(error => {
        console.error('There was a problem with the fetch operation:', error);
    });
});

// Update Modal

// Delete Modal
$(document).ready(function () {
    $('.delete-product').click(function (event) {
        event.preventDefault();  // Prevent the link from directing
        var productId = $(this).data('id');  // Get the product ID set in data-id attribute

        // Set the ID in the modal
        $('#deleteProduct').attr('data-product-id', productId);

        // Show the modal
        $('#deleteProduct').modal('show');
    });

    $('#deleteProduct .btn-danger').click(function () {
        var productId = $('#deleteProduct').data('product-id');

        // AJAX request to delete the product
        $.ajax({
            url: '/api/product/delete/' + productId,  // Adjusted URL to match the Spring Boot route
            type: 'DELETE',  // Adjusted HTTP method to DELETE as defined in the Spring Boot controller
            success: function (response) {
                // Handle the response from the server
                alert('Product Deleted Successfully!');
                $('#deleteProduct').modal('hide');
                location.reload();  // Reload the page to update the list
            },
            error: function (xhr) {
                alert('Error deleting product. Status: ' + xhr.status);
            }
        });
    });
});
// Delete Modal