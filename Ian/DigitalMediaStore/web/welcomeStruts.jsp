<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html/css; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Ian Mori">
        <title><bean:message key="welcome.title"/></title>
        <html:base/>
    </head>
    <body  background="img/uni.jpg" class ="backgroundFit">
    <center>
        <logic:messagesPresent message="true">
            <html:messages id="msg2" message="true" property="message1">
                <div class="infoMessageCheck">
                    <bean:write name="msg2"/>
                </div><br/>
            </html:messages>

            <html:messages id="msg2" message="true" property="warn">
                <div class="warnExclaim"  style="color: yellow">
                    <bean:write name="msg2"/>
                </div><br/>  
            </html:messages>

            <html:messages id="msg2" message="true" property="error">
                <div class="errorX">
                    <bean:write name="msg2"/>
                </div><br/>
            </html:messages>				  		
        </logic:messagesPresent>
    </center>

    <div class = "container">
        <div class = "jumbotron">
            <h1><bean:message key="welcome.heading" /></h1>
            <p>We sell software, video games, eBooks, gift cards, and more! All products are delivered electronically 
                through email. No physical shipment required!</p>
            <a href ="http://www.youtube.com/watch?v=Klbz1cJDgbI" class = "btn btn-success">Check this!</a>
            <a href ="https://twitter.com/"class = "btn btn-info">Tweet It!</a>
        </div>
    </div>

    <div id ="myCarousel" class ="carousel slide" data-ride="carousel">
        <div class = "carousel-inner">
            <div class = "item active">
                <img src="img/steam.jpg" alt="picture of steam" class = "img-responsive">
            </div>
            <div class = "item">
                <img src="img/software.jpg" alt="picture of software" class = "img-responsive">
            </div>
            <div class = "item">
                <img src="img/ebooks.jpg" alt="picture of ebooks" class = "img-responsive">
            </div>
            <div class = "item">
                <img src="img/giftcards.jpg" alt="picture of gift card" class = "img-responsive">
            </div>
        </div>
        <!--Created the left and right arrows on the carousel.-->
        <a class="carousel-control left" href ="#myCarousel" data-slide="prev">
            <span class ="icon-prev"></span>
        </a>
        <a class="carousel-control right" href ="#myCarousel" data-slide="next">
            <span class ="icon-next"></span>
        </a>
    </div>
    <br><br>

    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <p class="lead whiten">Categories</p>
                <div class="list-group">
                    <a class="list-group-item active">What's New?</a>
                    <a class="list-group-item">Recently Reduced!</a>              			              
                    <a class="list-group-item">Removed From Production</a>
                    <a class="list-group-item">Region Restricted Items</a>
                </div>
            </div>
            <!--Setting the carousel for the store content.-->
            <div class="col-md-9">
                <div class="row" style="margin-bottom:30px;">
                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <!--Setting the images in the carousel.-->
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img alt="picture of game of thrones" src="img/gameOfThrones.jpg" style="width: 100%;">
                                </div>
                                <div class="item">
                                    <img alt="picture of borderlands2" src="img/borderlands2.jpg" style="width: 100%;">
                                </div>
                                <div class="item">
                                    <img alt="picture of windows 7" src="img/win7.jpg" style="width: 100%;">
                                </div>
                                <div class="item">
                                    <img alt="picture of kaspersky" src="img/kaspersky.jpg" style="width: 100%;">
                                </div>
                                <div class="item">
                                    <img alt="picture of iTunes gift card" src="img/itunesGiftcard.jpg" style="width: 100%;">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--Setting the inner content pages for each store item.-->
                <div class="row">
                    <!--Sets the size, space, a picture for each block.-->
                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="img/gameOfThronesSmall.jpg" alt="smaller picture of game of thrones ebook set">
                            <div class="caption">
                                <h4 class="pull-right">$49.99</h4>
                                <h4><a href="http://www.georgerrmartin.com/grrm_book/a-game-of-thrones-a-song-of-ice-and-fire-book-one/">Game Of Thrones</a></h4>
                                <p>Redeemable worldwide in ALL regions.</p>
                            </div>
                        </div>
                    </div>
                    <!--Sets the size, space, a picture for each block.-->
                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="img/borderlands2Small.jpg" alt="smaller picture of borderlands2">
                            <div class="caption">
                                <h4 class="pull-right">$29.99</h4>
                                <h4><a href="http://www.borderlands2.com/">Borderlands 2</a></h4>
                                <p>Redeemable worldwide in ALL regions.</p>
                            </div>
                        </div>
                    </div>
                    <!--Sets the size, space, a picture for each block.-->
                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="img/win7Small.jpg" alt="smaller picture of windows 7">
                            <div class="caption">
                                <h4 class="pull-right">$109.99</h4>
                                <h4><a href="http://windows.microsoft.com/en-ca/windows7/products/upgrade#T1=tab01">Windows 7 Ultimate</a></h4>
                                <p>Redeemable worldwide in ALL regions.</p>
                            </div>
                        </div>
                    </div>
                    <!--Sets the size, space, a picture for each block.-->
                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="img/kasperskySmall.jpg" alt="smaller picture of kaspersky">
                            <div class="caption">
                                <h4 class="pull-right">$89.99</h4>
                                <h4><a href="http://www.kaspersky.ca/">Kaspersky Pure 3.0</a></h4>
                                <p>Redeemable worldwide in ALL regions.</p>
                            </div>
                        </div>
                    </div>
                    <!--Sets the size, space, a picture for each block.-->
                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="img/itunesGiftcardSmall.jpg" alt="smaller picture of itunes giftcard">
                            <div class="caption">
                                <h4 class="pull-right">$25.00</h4>
                                <h4><a href="http://store.apple.com/ca/personalize/itunes">iTunes Gift Card</a></h4>
                                <p>Redeemable worldwide in ALL regions.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--Scripts used to allow modals, carousels, and most Jquery to run. Also runs the boostrap script.-->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html:html>
