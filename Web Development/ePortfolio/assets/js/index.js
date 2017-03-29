/* Toggle between adding and removing the "responsive" class to topnav when the user clicks on the icon */
function myFunction() {
    var x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
        x.className += " responsive";
    } else {
        x.className = "topnav";
    }
}
//jQuery to collapse the navbar on scroll
$(window).scroll(function() {
    if ($(".navbar").offset().top > 50) {
        $(".navbar-fixed-top").addClass("top-nav-collapse");
    } else {
        $(".navbar-fixed-top").removeClass("top-nav-collapse");
    }
});

//jQuery to send contact information from contact form to email
/*$(document).ready(function() {
    $("#submit").on('click', function() {
        var name = $("#form_name").val();
        var email = $("#form_email").val();
        var message = $("#form_message").val();

    // Checking for blank fields.
    if (name == '' || email == '' || message == '') {
        alert("Please complete the required fields.");
    } else {
    // Returns successful data submission message when the entered information is stored in database.
    $.post("assets/php/contact.php", {
        name1: name,
        email1: email,
        message1: message,
        phone1: phone
    });
    }
});
});*/
