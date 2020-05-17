<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tourist Club</title>
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
                <li class="nav-item  mr-3">
                    <a class="nav-link" href="/">Home <span class="sr-only"></span></a>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Tables
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a target="_self" class="dropdown-item"  href="/web/amator/list">Amators</a>
                        <a target="_self" class="dropdown-item"  href="/web/captain/list">Captain</a>
                        <a target="_self" class="dropdown-item" href="/web/category/list">Category</a>
                        <a target="_self" class="dropdown-item" href="/web/coach/list">Coach</a>
                        <a target="_self" class="dropdown-item" href="/web/competition/list">Competition</a>
                        <a target="_self" class="dropdown-item" href="/web/group/list">Group</a>
                        <a target="_self" class="dropdown-item" href="/web/participation-in-competition/list">Part in competition</a>
                        <a target="_self" class="dropdown-item" href="/web/participation-in-tour/list">Part in tour</a>
                        <a target="_self" class="dropdown-item" href="/web/planned-tour/list">Planned tour</a>
                        <a target="_self" class="dropdown-item"  href="/web/schedule/list">Schedule</a>
                        <a target="_self" class="dropdown-item"  href="/web/section/list">Section</a>
                        <a target="_self" class="dropdown-item" href="/web/sportsman/list">Sportsman</a>
                        <a target="_self" class="dropdown-item" href="/web/tour/list">Tour</a>
                        <a target="_self" class="dropdown-item" href="/web/tourist/list">Tourist</a>
                        <a target="_self" class="dropdown-item" href="/web/tourist-in-group/list">Tourist in group</a>
                        <a target="_self" class="dropdown-item" href="/web/tour-type/list">Tour type</a>
                        <a target="_self" class="dropdown-item" href="/web/unplanned-tour/list">Unplanned tour</a>
                    </div>
                </li>

            </ul>

        </div>
    </div>

</nav>
<div class="container">
    <h3 class="pt-4 pb-2">Edit  </h3>
    <form name="tourist" class="form" action="" method="POST" style="width: 600px">
        <div class="form-group">
            <label>Tour name</label>
            <@spring.formInput "tourForm.tour_name" "class='form-control'" "text"/>
        </div>
        <div class="form-group">
            <label>Description</label>
            <@spring.formInput "tourForm.tour_description" "class='form-control'" "text"/>
        </div>
        <div class="form-group">
            <label>Instructor</label>
            <@spring.formSingleSelect "tourForm.instructor", mavs2, "class='form-control'"/>
        </div>
        <div class="form-group">
            <label>Group</label>
            <@spring.formSingleSelect "tourForm.group", mavs3, "class='form-control'"/>
        </div>
        <div class="form-group">
            <label>Tour full time</label>
            <br>
            <small>In days. The format is 'X' or 'X.Y'.</small>
            <@spring.formInput "tourForm.tour_full_time" "class='form-control'" "text"/>
        </div>
        <div class="form-group">
            <label>Payment</label>
            <br>
            <small>In hryvnias. The format is 'X' or 'X.Y'.</small>
            <@spring.formInput "tourForm.payment" "class='form-control'" "text"/>
        </div>
        <div class="form-group">
            <label>Route</label>
            <@spring.formInput "tourForm.route" "class='form-control'" "text"/>
        </div>
        <div class="form-group">
            <label>Route length(km)</label>
            <@spring.formInput "tourForm.route_length" "class='form-control'" "text"/>
        </div>
        <div class="form-group">
            <label>Tour date</label>
            <br>
            <small>The format is 'YYYY-MM-DD HH-mm'.</small>
            <@spring.formInput "tourForm.tour_date" "class='form-control'" "text"/>
        </div>
        <div class="form-group">
            <label>Type</label>
            <@spring.formSingleSelect "tourForm.tour_type", mavs4, "class='form-control'"/>
        </div>
        <div class="form-group">
            <label>Category</label>
            <@spring.formSingleSelect "tourForm.category", mavs, "class='form-control'"/>
        </div>

        <input class="btn btn-outline-secondary pl-3 pr-3 mt-3" type="submit" value="Edit"/>
    </form>
</div>

<div class="pt-5 pb-5">

</div>
<#--    <input class="btn btn-dark" type="submit" value="Create"/>-->
<div class="card-footer text-center fixed-bottom  bg-dark">
    <small class="text-muted">@TravelClub 2020</small>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
