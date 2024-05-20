//Read Modal
document.addEventListener('DOMContentLoaded', function () {
    // Get all 'view-details' links
    const viewDetailsLinks = document.querySelectorAll('.view-details');

    // Add click event listeners to each link
    viewDetailsLinks.forEach(link => {
        link.addEventListener('click', function (event) {
            event.preventDefault(); // Prevent the link from navigating

            // Extract data attributes from the clicked link
            const customerId = this.getAttribute('data-id');
            const customerFullName = this.getAttribute('data-fullname');
            const customerEmail = this.getAttribute('data-email');
            const customerAddress = this.getAttribute('data-address');
            const customerPhone = this.getAttribute('data-phone');
            const userId = this.getAttribute('data-userid');
            const userName = this.getAttribute('data-username');
            const userPassword = this.getAttribute('data-password');

            // Set these values in the modal
            document.getElementById('detailId').textContent = customerId;
            document.getElementById('detailFullName').textContent = customerFullName;
            document.getElementById('detailEmail').textContent = customerEmail;
            document.getElementById('detailAddress').textContent = customerAddress;
            document.getElementById('detailPhone').textContent = customerPhone;
            document.getElementById('detailUserId').textContent = userId;
            document.getElementById('detailUsername').textContent = userName;
            document.getElementById('detailPassword').textContent = userPassword;

            // Show the modal
            const customerDetailsModal = new bootstrap.Modal(document.getElementById('customerDetails'));
            customerDetailsModal.show();
        });
    });
});
// Read Modal

// Delete Modal
$(document).ready(function () {
    $('.delete-customer').click(function (event) {
        event.preventDefault();  // Prevent the link from directing
        var customerId = $(this).data('id');  // Get the customer ID set in data-id attribute

        // Set the ID in the modal
        $('#deleteCustomer').attr('data-customer-id', customerId);

        // Show the modal
        $('#deleteCustomer').modal('show');
    });

    $('#deleteCustomer .btn-danger').click(function () {
        var customerId = $('#deleteCustomer').data('customer-id');

        // AJAX request to delete the customer
        $.ajax({
            url: '/api/customer/delete/' + customerId,  // Adjusted URL to match the Spring Boot route
            type: 'DELETE',  // Adjusted HTTP method to DELETE as defined in the Spring Boot controller
            success: function (response) {
                // Handle the response from the server
                alert('Customer Deleted Successfully!');
                $('#deleteCustomer').modal('hide');
                location.reload();  // Reload the page to update the list
            },
            error: function (xhr) {
                alert('Error deleting customer. Status: ' + xhr.status);
            }
        });
    });
});
// Delete Modal

// Create Modal
$(document).ready(function () {
    $('.create-customer').click(function (event) {
        event.preventDefault();  // Ngăn chặn hành vi mặc định của thẻ <a>
        $('#addCustomer').modal('show');  // Hiển thị modal
    });
});

$('#addCustomer .btn-primary').click(function () {
    var customerData = {
        id: $('#idCustomer').val(),
        fullName: $('#nameCustomer').val(),
        phone: $('#phoneCustomer').val(),
        address: $('#addressCustomer').val()
    };

    $.ajax({
        url: '/api/customer/add',  // Đường dẫn tới endpoint
        type: 'POST',  // Phương thức HTTP
        contentType: 'application/json',  // Loại nội dung đang gửi
        data: JSON.stringify(customerData),  // Chuyển dữ liệu đối tượng thành chuỗi JSON
        success: function (response) {
            alert('Customer added successfully!');  // Thông báo thành công
            $('#addCustomer').modal('hide');  // Ẩn modal
            location.reload();  // Tải lại trang để cập nhật danh sách khách hàng
        },
        error: function () {
            alert('Error adding customer.');  // Thông báo lỗi
        }
    });
});
// Create Modal

// Update Modal
// Function to handle the click event on the update-customer link
document.querySelectorAll('.update-customer').forEach(link => {
    link.addEventListener('click', function (event) {
        event.preventDefault(); // Prevent the default link behavior

        // Get the row corresponding to the clicked link
        const row = this.closest('tr');

        // Get customer data from the row
        const id = this.getAttribute('data-id');
        const fullName = this.getAttribute('data-fullname');
        const email = this.getAttribute('data-email');
        const address = this.getAttribute('data-address');
        const phone = this.getAttribute('data-phone');
        // const userId = this.getAttribute('data-userid');
        // const userName = this.getAttribute('data-username');
        // const userPassword = this.getAttribute('data-password');

        // Fill the modal form with customer data
        document.getElementById('idEditCustomer').value = id;
        document.getElementById('nameEditCustomer').value = fullName;
        document.getElementById('phoneEditCustomer').value = phone;
        document.getElementById('emailEditCustomer').value = email;
        document.getElementById('addressEditCustomer').value = address;

        // Show the modal
        $('#editCustomer').modal('show');
    });
});

// Function to handle the click event on the "Save" button in the modal
document.getElementById('saveCustomerChanges').addEventListener('click', function (event) {
    // Get updated customer data from the modal form
    const id = document.getElementById('idEditCustomer').value;
    const fullName = document.getElementById('nameEditCustomer').value;
    const phone = document.getElementById('phoneEditCustomer').value;
    const email = document.getElementById('emailEditCustomer').value;
    const address = document.getElementById('addressEditCustomer').value;

    // Create an object with the updated data
    const updatedCustomer = {
        id: id,
        fullName: fullName,
        email: email,
        phone: phone,
        address: address
    };

    // Here you can send the updated data to the backend using AJAX
    fetch('/api/customer/update', {
        method: 'POST',
        body: JSON.stringify(updatedCustomer),
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
        console.log('Customer updated successfully:', data);
        // Hide the modal
        $('#editCustomer').modal('hide');
        // Reload the page
        location.reload();
    }).catch(error => {
        console.error('There was a problem with the fetch operation:', error);
    });
});

// Update Modal

// Search Customer
document.addEventListener("DOMContentLoaded", function() {
    const searchBar = document.querySelector('input[type="search"]');
    searchBar.addEventListener('input', function(event) {
        const searchText = event.target.value.toLowerCase();
        const tableRows = document.querySelectorAll('tbody tr');
        tableRows.forEach(function(row) {
            const fullName = row.querySelector('.align-middle.text-center:nth-child(2)').textContent.toLowerCase();
            const email = row.querySelector('.align-middle.text-center:nth-child(3)').textContent.toLowerCase();
            const address = row.querySelector('.align-middle.text-center:nth-child(4)').textContent.toLowerCase();
            const phoneNumber = row.querySelector('.align-middle.text-center:nth-child(5)').textContent.toLowerCase();
            if (fullName.includes(searchText) || email.includes(searchText) || address.includes(searchText) || phoneNumber.includes(searchText)) {
                row.style.display = '';
            } else {
                row.style.display = 'none';
            }
        });
    });
});
// Search Customer