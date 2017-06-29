<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <meta charset="utf-8">
    <title>JavaRush TestUsers</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap-responsive.min.css" rel="stylesheet">


    <style>

        .container {
            width: 100%;
            margin-left: 10%;
            margin-right: 5%;
            margin-top: 2%;
            height: 95%;
        }

        .container1 {
            width: 100%;
            margin-left: 50%;
            margin-right: 5%;
            margin-top: 2%;
            height: 95%;
            top: 0;
        }

        td {
            padding: 5px;
            vertical-align: top;
        }


    </style>
</head>
<body>
<table width="70%">
    <tr>
        <td width="70%">

            <div class="container">
                <h2>Users</h2>

                <div>
                    <table>
                        <tr>
                            <td>
                                <form:form action="/" method="get"><input class="btn btn-primary" type="submit"
                                                                          size="XSmall" value="Show All"/>
                                </form:form>
                            </td>
                            <td width="120">
                            </td>
                            <td>
                                <form:form action="/search/">
                            <th><label for="name">Search by Name</label></th>
                            <td width="2">
                            </td>
                            <th><input class="form-control" type="name" id="id" name="name" placeholder=" "/></th>
                            <td width="2">
                            </td>
                            <th><input class="btn btn-success" type="submit" value="Search"/></th>
                            </form:form>
                            </td>
                        </tr>
                    </table>
                </div>
                </br>


                <c:if test="${!empty users}">


                    <table class="table table-bordered table-striped table-hover header-fixed">
                        <thead>
                        <tr>
                            <td width="40px">ID</td>
                            <th width="40px">Admin</th>
                            <th>Name</th>
                            <th width="40px">Age</th>
                            <th width="40px">CreatedDate</th>
                            <th width="120px">&nbsp;</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td>${user.id}</td>
                                <td width="40px">${user.isAdmin}</td>
                                <td>${user.name}</td>
                                <td>${user.age}</td>
                                <td>${user.createdDate}</td>
                                <td width="120px">
                                    <table>
                                        <tr>
                                            <td><form:form action="edit/${user.id}" method="post"><input type="submit"
                                                                                                         size="XSmall"
                                                                                                         class="btn btn-info btn-mini"
                                                                                                         value="Edit..."/>
                                            </form:form></td>
                                            <td><form:form action="remove/${user.id}" method="post"><input type="submit"
                                                                                                           size="XSmall"
                                                                                                           class="btn btn-danger btn-mini"
                                                                                                           value="Delete"/>
                                            </form:form></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>

            </div>
        </td>
        <td>

            <br/>

            <div class="container1">
                <a href="/fill">
                    <button type="submit" class="btn btn-primary" size="Small">Fill User</button>
                </a> <br>

                <c:if test="${user.id==0}">
                <h2>Add User</h2>
                </c:if>
                <c:if test="${!(user.id==0)}">
                <h2>Edit User</h2>
                </c:if>
                <c:url var="addAction" value="/add"/>
                <form:form action="${addAction}" commandName="user">
                    <form:hidden path="id"/>
                <form:label path="isAdmin">
                    <spring:message text="Admin:"/>
                </form:label>
                    <form:checkbox path="isAdmin"/>
                <br>
                <form:label path="name">Name:</form:label>
                    <form:input path="name" class="form-control" placeholder="Name"/>
                <br/>

                <form:label path="age">Age:</form:label>
                    <form:input path="age" class="form-control" placeholder="Age"/>
                <br/>

                <c:if test="${user.id==0}">
                <button type="submit" class="btn btn-success" size="Small">Add User</button>
                </c:if>
                <c:if test="${!(user.id==0)}">
                <button type="submit" class="btn btn-warning" size="Small">Edit User</button>
                </c:if>
                </form:form>
                <br/>
        </td>
    </tr>
</table>


</body>
</html>
