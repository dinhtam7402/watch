// Read Modal
document.addEventListener('DOMContentLoaded', function () {
    // Get all 'view-order' links
    const viewOrderDetails = document.querySelectorAll('.view-order');

    // Add click event listeners to each link
    viewOrderDetails.forEach(link => {
        link.addEventListener('click', function (event) {
            event.preventDefault(); // Prevent the link from navigating

            // Extract data attributes from the clicked link
            const id = this.getAttribute('data-id');

            // Fetch order details from server
            fetch(`/api/orders/view/${id}`)
                .then(response => response.json())
                .then(data => {

                    // Update customer information in the modal
                    document.getElementById('orderId').textContent = data.id;
                    document.getElementById('orderCustomerId').textContent = data.customer.id;
                    document.getElementById('orderCustomerFullName').textContent = data.customer.fullName;
                    document.getElementById('orderCustomerAddress').textContent = data.customer.address;
                    document.getElementById('orderCustomerPhone').textContent = data.customer.phone;
                    document.getElementById('orderCustomerEmail').textContent = data.customer.email;

                    const orderDate = new Date(data.orderDate);
                    const formattedDate = orderDate.toISOString().split('T')[0];
                    document.getElementById('orderDate').textContent = formattedDate;


                    document.getElementById('orderTotalAmount').textContent = data.totalAmount;
                    document.getElementById('orderStatus').textContent = data.status;

                    // Check if data.orderDetails is defined before attempting to iterate over it
                    if (data.orderDetails) {
                        // Proceed with processing order details
                        const productDetails = document.getElementById('productDetails');
                        productDetails.innerHTML = ''; // Clear previous entries

                        data.orderDetails.forEach(detail => {
                            const row = `<tr>
                                            <td class="align-middle text-center">${detail.product.name}</td>
                                            <td class="align-middle text-center">${detail.quantity}</td>
                                            <td class="align-middle text-center">${detail.unitPrice}</td>
                                            <td class="align-middle text-center">${detail.quantity * detail.unitPrice}</td>
                                        </tr>`;
                            productDetails.innerHTML += row;
                        });
                    } else {
                        // Handle case where order details are not available
                        console.error('Error: No order details found in the response.');
                    }



                    // Show the modal
                    const orderDetailsModal = new bootstrap.Modal(document.getElementById('orderDetails'));
                    orderDetailsModal.show();
                })
                .catch(error => console.error('Error loading the order details:', error));
        });
    });
});
// Read Modal
