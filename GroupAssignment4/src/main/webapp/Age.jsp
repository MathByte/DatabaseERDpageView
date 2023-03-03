<%@ page import="java.util.List" %>
<%@ page import="com.sk.groupassignment4.Beans.Ages" %><%--
  Created by IntelliJ IDEA.
  User: khach
  Date: 2/27/2023
  Time: 9:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

<jsp:useBean id="myBean" class="com.sk.groupassignment4.Beans.Ages" />


<main role="main">


    <section class="jumbotron text-center">
        <div class="container">
            <h1 class="jumbotron-heading">GeoGraphic Areas</h1>

        </div>
    </section>

    <div class="album py-5 bg-light">
        <div class="container">

            <div class="row">
                <a href=index.jsp>Home Page</a>
                <h2>Displayed ages for 2016 nad 2021.</h2>
                <div class="col-md-4">
                    <div class="card mb-4 box-shadow">
                        <h2 class="card-img-top"> 2016 </h2>
                        <div class="card-body">
                            <div class="d-flex justify-content-between align-items-center">
                                <% Ages rows = myBean.getAllAges2016();%>
                                <table class="table table-borderless">


                                    <tbody>
                                    <tr>
                                        <th scope="row">Ages Combined :</th>
                                        <td><%=rows.getCombined() %></td>


                                    </tr>
                                    <tr>
                                        <th scope="row">Ages Males only :</th>
                                        <td><%=rows.getMale() %></td>


                                    </tr>
                                    <tr>
                                        <th scope="row">Ages Females only :</th>
                                        <td><%=rows.getFemale() %></td>


                                    </tr>
                                    </tbody>


                                </table>


                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card mb-4 box-shadow">
                        <h2 class="card-img-top"> 2021 </h2>
                        <div class="card-body">
                            <div class="d-flex justify-content-between align-items-center">
                                <% Ages rows2 = myBean.getAllAges2021();%>
                                <table class="table table-borderless">
                                <tbody>
                                <tr>
                                    <th scope="row">Ages Combined :</th>
                                    <td><%=rows2.getCombined() %></td>


                                </tr>
                                <tr>
                                    <th scope="row">Ages Males only :</th>
                                    <td><%=rows2.getMale() %></td>


                                </tr>
                                <tr>
                                    <th scope="row">Ages Females only :</th>
                                    <td><%=rows2.getFemale() %></td>


                                </tr>
                                </tbody>


                                </table>

                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

</main>
















<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>

</body>
</html>
