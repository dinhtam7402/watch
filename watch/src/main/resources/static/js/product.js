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
