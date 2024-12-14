<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="templates/head.jsp"/>

<body>
<div class="site-wrap">
    <jsp:include page="templates/header.jsp"/>

    <div class="site-blocks-cover" style="background-image: url(static/images/hero_1.jpg);" data-aos="fade">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <!-- Search Bar Section -->
            <div class="col-12 col-md-6 text-center">
                <form action="search" method="get" class="site-block-top-search">
                    <div class="input-group">
                        <input
                                id="input"
                                class="form-control border-0 search-input"
                                type="search"
                                autocomplete="off"
                                spellcheck="false"
                                role="combobox"
                                aria-controls="matches"
                                aria-expanded="false"
                                aria-live="polite"
                                placeholder="Search for books by Title and Author">
                        <div class="input-group-append">
                            <button type="submit" class="input-group-text search-icon" id="basic-addon1">
                                <i class="icon icon-search"></i>
                            </button>
                        </div>
                    </div>
                </form>
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

<div class="site-section site-section-sm site-blocks-1">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4" data-aos="fade-up" data-aos-delay="100">
                <div class="icon mr-4 align-self-start">
                    <span class="icon-refresh2"></span>
                </div>

                <div class="text">
                    <h2 class="text-uppercase">Free Returns</h2>
                    <p>Enjoy peace of mind with free returns within three days on all orders!</p>
                </div>
            </div>

            <div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4" data-aos="fade-up" data-aos-delay="100">
                <div class="icon mr-4 align-self-start">

                </div>
                <div class=" ">
                    <h2 class=" "> </h2>

                </div>
            </div>

            <div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4" data-aos="fade-up" data-aos-delay="200">
                <div class="icon mr-4 align-self-start">
                    <span class="icon-help"></span>
                </div>
                <div class="text">
                    <h2 class="text-uppercase">Customer Support</h2>
                    <p>Our team is here to help! For urgent inquiries, contact us at helplie: 123123.</p>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="templates/featured-products.jsp"/>

<div class="site-section block-8">
    <div class="container">
        <div class="row justify-content-center  mb-5">
            <div class="col-md-7 site-section-heading text-center pt-4">
                <h2>Big Sale!</h2>
            </div>
        </div>
        <div class="row align-items-center">
            <div class="col-md-12 col-lg-7 mb-5">
                <a href="#"><img src="static/images/blog_1.jpg" alt="Image placeholder"
                                 class="img-fluid rounded"></a>
            </div>
            <div class="col-md-12 col-lg-5 text-center pl-md-5">
                <h2><a href="#">"Enjoy 10% off on all items – shop now and save!"</a></h2>
                <p class="post-meta mb-4"> </span>
                    December 31, 2024</p>
                <p><a href="shop" class="btn btn-primary btn-sm">Shop Now</a></p>
            </div>
        </div>
    </div>
</div>

<jsp:include page="templates/footer.jsp"/>
</div>

<jsp:include page="templates/scripts.jsp"/>
</body>
</html>