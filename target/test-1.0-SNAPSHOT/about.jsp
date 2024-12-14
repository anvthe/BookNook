<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="templates/head.jsp"/>

<body>
<div class="site-wrap">
    <% request.setAttribute("about_active", "active"); %>
    <jsp:include page="templates/header.jsp"/>

    <div class="bg-light py-3">
        <div class="container">
            <div class="row">
                <div class="col-md-12 mb-0"><a href="index.jsp">Home</a> <span class="mx-2 mb-0">/</span> <strong
                        class="text-black">About</strong></div>
            </div>
        </div>
    </div>

    <div class="site-section border-bottom" data-aos="fade">
        <div class="container">
            <div class="row mb-5">
                <div class="col-md-6">
                    <div class="block-16">
                        <figure>
                            <img src="static/images/blog_1.jpg" alt="Image placeholder" class="img-fluid rounded">
                            <a href="https://vimeo.com/channels/staffpicks/93951774" class="play-button popup-vimeo">
                                <span class="ion-md-play"></span>
                            </a>
                        </figure>
                    </div>
                </div>

                <div class="col-md-1">

                </div>

                <div class="col-md-5">
                    <div class="site-section-heading pt-3 mb-4">
                        <h2 class="text-black">How We Started</h2>
                    </div>
                    <p>At BookNook, our journey began with a simple yet powerful idea: to create a place where book lovers could easily discover and purchase the best books and literary accessories. What started as a small online venture has since grown into a vibrant community of readers, authors, and enthusiasts, all brought together by a shared passion for reading.</p>
                    <p>Our mission is to make books and related products more accessible to everyone, offering a curated selection of titles, from timeless classics to the latest bestsellers, alongside unique literary accessories that complement the reading experience. Whether you're a casual reader or a lifelong bibliophile, we aim to bring the world of books right to your doorstep.</p>
                    <p>As we continue to grow, we remain committed to providing exceptional customer service and supporting authors and creators who bring stories to life. At BookNook, we believe that the right book can change your life—and we're here to help you find it.</p>

                </div>
            </div>
        </div>
    </div>

    <div class="site-section border-bottom" data-aos="fade">
        <div class="container">
            <div class="row justify-content-center mb-5">
                <div class="col-md-7 site-section-heading text-center pt-4">
                    <h2>The Team</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-lg-3">
                    <div class="block-38 text-center">
                        <div class="block-38-img">
                            <div class="block-38-header">

                                <h3 class="block-38-heading h4"> </h3>
                                <p class="block-38-subheading"> </p>
                            </div>
                            <div class="block-38-body">

                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-3">
                    <div class="block-38 text-center">
                        <div class="block-38-img">
                            <div class="block-38-header">
                                <img src="static/images/person_2.jpg" alt="Image placeholder" class="mb-4">
                                <h3 class="block-38-heading h4">Amjad Alam</h3>
                                <p class="block-38-subheading">Founder</p>
                            </div>
                            <div class="block-38-body">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-3">
                    <div class="block-38 text-center">
                        <div class="block-38-img">
                            <div class="block-38-header">
                                <img src="static/images/person_3.jpg" alt="Image placeholder" class="mb-4">
                                <h3 class="block-38-heading h4">Chathurika Goonawardane</h3>
                                <p class="block-38-subheading">Founder</p>
                            </div>
                            <div class="block-38-body">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="site-section site-section-sm site-blocks-1 border-0" data-aos="fade">
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


                <div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4" data-aos="fade-up" data-aos-delay="">
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

    <jsp:include page="templates/footer.jsp"/>
</div>

<jsp:include page="templates/scripts.jsp"/>
</body>
</html>