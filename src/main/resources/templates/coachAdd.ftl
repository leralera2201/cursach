<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tourist Add</title>
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
<div class="container">
    <h3 class="pt-4 pb-2">Add new </h3>
    <form name="tourist" class="form" action="" method="POST" >
        <div class="form-group">
            <label>Tourist</label>
            <@spring.formSingleSelect "coachForm.tourist", mavs, "class='form-control'"/>
        </div>
        <div class="form-group">
            <label>Started work year</label>
            <@spring.formInput "coachForm.started_work_year" "class='form-control'" "text"/>
        </div>
        <div class="form-group">
            <label>Salary</label>
            <@spring.formInput "coachForm.salary" "class='form-control'" "text"/>
        </div>
        <div class="form-group">
            <label>Speciality</label>
            <@spring.formInput "coachForm.speciality" "class='form-control'" "text"/>
        </div>

        <input class="btn btn-outline-secondary pl-3 pr-3 mt-3" type="submit" value="Create"/>
    </form>
</div>

<div class="pt-5 pb-5">

</div>
<div class="card-footer text-center fixed-bottom  bg-dark">
    <small class="text-muted">@TravelClub 2020</small>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
