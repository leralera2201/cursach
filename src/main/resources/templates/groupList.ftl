<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Group List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="../static/css/style.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="/">Tourist Club</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="navbar-collapse collapse w-100 order-3 dual-collapse2" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active mr-3">
                    <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Tables
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a target="_self" class="dropdown-item"  href="/web/amator/list">Amators</a>
                        <a target="_self" class="dropdown-item"  href="/web/captain/list">Captain</a>
                        <a target="_self" class="dropdown-item" href="/web/category/list">Category</a>
                        <a target="_self" class="dropdown-item" href="/web/coach/list">coach</a>
                        <a target="_self" class="dropdown-item" href="/web/competition/list">competition</a>
                        <a target="_self" class="dropdown-item" href="/web/group/list">group</a>
                        <a target="_self" class="dropdown-item" href="/web/participation-in-competition/list">participation in competition</a>
                        <a target="_self" class="dropdown-item" href="/web/planned-tour/list">planned tour</a>
                        <a target="_self" class="dropdown-item"  href="/web/schedule/list">schedule</a>
                        <a target="_self" class="dropdown-item"  href="/web/section/list">section</a>
                        <a target="_self" class="dropdown-item" href="/web/sportsman/list">sportsman</a>
                        <a target="_self" class="dropdown-item" href="/web/tour/list">tour</a>
                        <a target="_self" class="dropdown-item" href="/web/tourist/list">tourist</a>
                        <a target="_self" class="dropdown-item" href="/web/tourist-in-group/list">tourist in group</a>
                        <a target="_self" class="dropdown-item" href="/web/tour-type/list">tour type</a>
                        <a target="_self" class="dropdown-item" href="/web/unplanned-tour/list">unplanned tour</a>
                    </div>
                </li>

            </ul>

        </div>
    </div>

</nav>

<h3 class="text-center pt-4 pb-2">Group List</h3>
<div class="container text-center">
    <div class="input-group mb-3 " style="display: flex; justify-content: center; align-items: center">
        <div class="input-group-prepend ">
            <button class="btn btn-outline-secondary dropdown-toggle " type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Find  person by name </button>
            <div class="dropdown-menu ">
                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <a class="dropdown-item" href="#">Something else here</a>
                <div role="separator" class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">Separated link</a>
            </div>
        </div>
        <form name="search" class="col-6" style="display: flex" action="" method="POST">
            <@spring.formInput "searchForm.name"  "class='form-control'" "text"/>
            <input type="submit" class="btn btn-outline-secondary form-control col-2 pl-2 pr-2 ml-2" value="Search"/>
        </form>


    </div>
    <div>
        <a href="/web/group/sorted-list" class="btn btn-outline-secondary mb-4">Sort table by name</a>
        <a href="/web/group/list" class="btn btn-outline-secondary mb-4">Undo sort</a>
    </div>


    <table class="table table-hover pt-5">
        <thead>
        <tr class="table-secondary">
            <th scope="col">#</th>
            <th scope="col">Group name</th>
            <th scope="col">Description</th>
            <th scope="col">Captain</th>
            <th scope="col">Section</th>
            <th scope="col">Coach</th>
            <th scope="col">Delete</th>
            <th scope="col">Edit</th>
        </tr>
        </thead>
        <tbody>
        <#list groups as group>
            <tr>
                <td>${group?index + 1}</td>
                <td>${group.group_name}</td>
                <td>${group.description}</td>
                <td>${group.assigned_by.nameAndSurname}</td>
                <td>${group.section.section_name}</td>
                <td>${group.coach.tourist.nameandSurname}</td>


                <td><a href="delete/${group.id}">
                        <button class="btn btn-outline-secondary">Delete</button>
                    </a></td>
                <td><a href="edit/${group.id}"><button class="btn btn-outline-secondary">Edit</button></a></td>
                <#--            <td><button>Edit</button></td>-->
            </tr>
        </#list>
        </tbody>
    </table>

    <a class="btn btn-outline-secondary" href="create" role="button">Add new</a>

</div>
<div class="card-footer text-center fixed-bottom  bg-dark mt-3">
    <small class="text-muted">@TravelClub 2020</small>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
