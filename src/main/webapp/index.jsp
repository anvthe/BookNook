<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="templates/head.jsp"/>

<body>
<div class="site-wrap">
    <jsp:include page="templates/header.jsp"/>

    <div class="site-blocks-cover" style="background-image: url(static/images/home_1.jpg);" data-aos="fade">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <!-- Search Bar Section -->
            <div class="col-12 col-md-6 text-center">
                <form action="search" method="get" class="site-block-top-search" id="search-form">
                    <div class="input-group">
                        <input id="input"
                               class="form-control border-0 search-input"
                               type="search"
                               autocomplete="off"
                               spellcheck="false"
                               placeholder="Search for books by Title and Author"
                               name="keyword"
                               oninput="searchProducts()">
                        <div class="input-group-append">
                            <button type="submit" class="input-group-text search-icon" id="basic-addon1">
                                <i class="icon icon-search"></i>
                            </button>
                        </div>
                    </div>
                </form>
                <div id="search-results" style="position: absolute; background-color: Red; z-index: 10;"></div>
            </div>



            <!-- Text Content Section (Beside Search Bar) -->
            <div class="col-12 col-md-6 text-center text-md-left pt-5 pt-md-0">
                <h1 class="mb-2 text-white" >Books & Literary Accessories world. Find everything you need, right here!!</h1>
                <div class="intro-text">
                        <a href="shop" class="btn btn-sm btn-primary">Shop Now</a>
                </div>
            </div>
        </div>
    </div>
</div>


<jsp:include page="templates/featured-products.jsp"/>

<jsp:include page="templates/footer.jsp"/>
</div>

<jsp:include page="templates/scripts.jsp"/>
</body>
</html>

<script>
    function searchProducts() {
        let keyword = document.getElementById("input").value;

        if (keyword.length === 0) {
            document.getElementById("search-results").innerHTML = ""; // Clear results if input is empty
            return;
        }

        // Make AJAX request
        fetch("search?keyword=" + encodeURIComponent(keyword))
            .then(response => response.json()) // Expect JSON response
            .then(data => {
                let resultsDiv = document.getElementById("search-results");
                resultsDiv.innerHTML = ""; // Clear previous results

                if (data.length > 0) {
                    let ul = document.createElement("ul");
                    ul.style.listStyle = "none";
                    ul.style.padding = "0";
                    console.log("SEARCH result:"+ data);
                    data.forEach(product => {
                        console.log("SEARCH result:"+ product.name);
                        let li = document.createElement("li");
                        li.style.padding = "5px 10px";
                        li.style.cursor = "pointer";
                        li.style.color = "white"; // White text
                        li.onmouseover = () => li.style.backgroundColor = "#FF3333"; // Highlight effect
                        li.onmouseout = () => li.style.backgroundColor = "red";

                        // Add product name and description
                        li.innerHTML = product.name + " - " + product.price;


                        // Navigate to product detail page on click
                        li.onclick = () => {
                            if (product.id) {
                                window.location.href = "http://localhost:8080/product-detail?id="+product.id;
                            } else {
                                alert("Product ID is missing. Please try again.");
                            }
                        };

                        ul.appendChild(li);
                    });

                    resultsDiv.appendChild(ul);
                } else {
                    resultsDiv.innerHTML = "<p style='color:white;'>No products found</p>";
                }
            })
            .catch(error => {
                console.error("Error fetching products:", error);
                resultsDiv.innerHTML = "<p style='color:white;'>Failed to load products. Please try again.</p>";
            });
    }

    function selectProduct(product) {
        // Validate product ID before redirection
        if (product.id) {
            window.location.href = `http://localhost:8080/product-detail?id=${product.id}`;
        } else {
            alert("Product ID is missing. Please try again.");
        }
    }

</script>