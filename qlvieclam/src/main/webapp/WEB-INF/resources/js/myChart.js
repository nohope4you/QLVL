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




