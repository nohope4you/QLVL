<%-- 
    Document   : ThongKe
    Created on : Aug 20, 2023, 8:48:46 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <h2 style="margin-left: 500px;">THỐNG KÊ</h2>
    <form>



        <input class="form-control me-auto" type="number" id="year"  style="margin-bottom: 10px;" required placeholder="Nhập năm cần thống kê .....">

        <button class="btn btn-primary" onClick="showName()" type="button">Thống kê theo năm</button>

        <button class="btn btn-primary" onClick="GetName()" type="button">Thống kê theo số lượng</button>
        <button class="btn btn-primary" onClick="Quy1()" type="button">Quý 1</button>
        <button class="btn btn-primary" onClick="Quy2()" type="button">Quý 2</button>
        <button class="btn btn-primary" onClick="Quy3()" type="button">Quý 3</button>
        <button class="btn btn-primary" onClick="Quy4()" type="button">Quý 4</button>
        <button class="btn btn-primary" onClick="destroy()" type="button">Xoá</button>

    </form>
    <canvas id="myChart" style="width: auto;">

    </canvas>

</div>
<script>
    const ctx = document.getElementById('myChart');
    let name = [];
    let number = [];

    var chart;
    function destroy() {
        chart.destroy();
        document.getElementById("year") === null;
    }
    function Quy1() {
        var year = document.getElementById("year").value;
        if (year)
        {
            $.ajax({
                url: "http://localhost:8080/QLViecLam/api/GetNameQuy1/" + year,
                method: "GET",
                success: function (n) {
                    name = n;
                    console.log(name);
                    $.ajax({
                        url: "http://localhost:8080/QLViecLam/api/GetNumberQuy1/" + year,
                        method: "GET",
                        success: function (res) {
                            number = res;
                            console.log(number);
                            chart = new Chart(ctx, {
                                type: 'bar',
                                data: {
                                    labels: name,
                                    datasets: [{
                                            label: 'Số lượng nghề trong Quý 1 năm '+year,
                                            data: res,
                                            borderWidth: 1
                                        }]
                                },
                                options: {
                                    scales: {
                                        y: {
                                            beginAtZero: true
                                        }
                                    }
                                }
                            });

                        }
                    })
                }
            });
        }
    }
    function Quy2() {
        var year = document.getElementById("year").value;
        if (year)
        {
            $.ajax({
                url: "http://localhost:8080/QLViecLam/api/GetNameQuy2/" + year,
                method: "GET",
                success: function (n) {
                    name = n;
                    console.log(name);
                    $.ajax({
                        url: "http://localhost:8080/QLViecLam/api/GetNumberQuy2/" + year,
                        method: "GET",
                        success: function (res) {
                            number = res;
                            console.log(number);
                            chart = new Chart(ctx, {
                                type: 'bar',
                                data: {
                                    labels: name,
                                    datasets: [{
                                            label: 'Số lượng nghề trong Quý 2 năm '+year,
                                            data: res,
                                            borderWidth: 1
                                        }]
                                },
                                options: {
                                    scales: {
                                        y: {
                                            beginAtZero: true
                                        }
                                    }
                                }
                            });

                        }
                    })
                }
            });
        }
    }
    function Quy3() {
        var year = document.getElementById("year").value;
        if (year)
        {
            $.ajax({
                url: "http://localhost:8080/QLViecLam/api/GetNameQuy3/" + year,
                method: "GET",
                success: function (n) {
                    name = n;
                    console.log(name);
                    $.ajax({
                        url: "http://localhost:8080/QLViecLam/api/GetNumberQuy3/" + year,
                        method: "GET",
                        success: function (res) {
                            number = res;
                            console.log(number);
                            chart = new Chart(ctx, {
                                type: 'bar',
                                data: {
                                    labels: name,
                                    datasets: [{
                                            label: 'Số lượng nghề trong Quý 3 năm '+year,
                                            data: res,
                                            borderWidth: 1
                                        }]
                                },
                                options: {
                                    scales: {
                                        y: {
                                            beginAtZero: true
                                        }
                                    }
                                }
                            });

                        }
                    })
                }
            });
        }
    }
    function Quy4() {
        var year = document.getElementById("year").value;
        if (year)
        {
            $.ajax({
                url: "http://localhost:8080/QLViecLam/api/GetNameQuy4/" + year,
                method: "GET",
                success: function (n) {
                    name = n;
                    console.log(name);
                    $.ajax({
                        url: "http://localhost:8080/QLViecLam/api/GetNumberQuy4/" + year,
                        method: "GET",
                        success: function (res) {
                            number = res;
                            console.log(number);
                            chart = new Chart(ctx, {
                                type: 'bar',
                                data: {
                                    labels: name,
                                    datasets: [{
                                            label: 'Số lượng nghề trong Quý 4 năm '+year,
                                            data: res,
                                            borderWidth: 1
                                        }]
                                },
                                options: {
                                    scales: {
                                        y: {
                                            beginAtZero: true
                                        }
                                    }
                                }
                            });

                        }
                    })
                }
            });
        }
    }
    function showName() {

        var year = document.getElementById("year").value;
        if (year)
        {
            $.ajax({
                url: "http://localhost:8080/QLViecLam/api/GetNameByYear/" + year,
                method: "GET",
                success: function (n) {
                    name = n;
                    console.log(name);
                    $.ajax({
                        url: "http://localhost:8080/QLViecLam/api/GetNumber/" + year,
                        method: "GET",
                        success: function (res) {
                            number = res;
                            console.log(number);
                            chart = new Chart(ctx, {
                                type: 'bar',
                                data: {
                                    labels: name,
                                    datasets: [{
                                            label: 'Số lượng nghề trong năm',
                                            data: res,
                                            borderWidth: 1
                                        }]
                                },
                                options: {
                                    scales: {
                                        y: {
                                            beginAtZero: true
                                        }
                                    }
                                }
                            });

                        }
                    })
                }
            });
        }
    }
    function GetName() {
        $.ajax({
            url: "http://localhost:8080/QLViecLam/api/GetThongKeByNameMajor/",
            method: "GET",
            success: function (n) {
                name = n;
                console.log(name);
                $.ajax({
                    url: "http://localhost:8080/QLViecLam/api/GetThongKeByNumberMajor/",
                    method: "GET",
                    success: function (res) {
                        number = res;
                        console.log(number);
                        chart = new Chart(ctx, {
                            type: 'bar',
                            data: {
                                labels: name,
                                datasets: [{
                                        label: 'Số lượng đơn ứng tuyển của các ngành nghề',
                                        data: res,
                                        borderWidth: 1
                                    }]
                            },
                            options: {
                                scales: {
                                    y: {
                                        beginAtZero: true
                                    }
                                }
                            }
                        });
                    }
                });
            }
        });
    }



</script>

