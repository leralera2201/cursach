package edu.lera.cursach.dataSet;

import edu.lera.cursach.model.Category;
import edu.lera.cursach.model.Tourist;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataSet {



    private List<edu.lera.cursach.model.Category> categories = new ArrayList<>(Arrays.asList(
            new edu.lera.cursach.model.Category("1", "low", 1,0,
                    LocalDateTime.now(), LocalDateTime.now()),
            new edu.lera.cursach.model.Category("2", "average", 2,2,
                    LocalDateTime.now(), LocalDateTime.now()),
            new edu.lera.cursach.model.Category("3", "high", 3,5,
                    LocalDateTime.now(), LocalDateTime.now())

    ));

    public List<edu.lera.cursach.model.Category> getCategories() {
        return categories;
    }

    public void setCategories(List<edu.lera.cursach.model.Category> categories) {
        this.categories = categories;
    }

    private List<edu.lera.cursach.model.Tourist> tourists = new ArrayList<>(Arrays.asList(
            new edu.lera.cursach.model.Tourist("1", "Ivanov", "Ivan","Ivanovich",
                    "can't swimming", "0998765432", LocalDate.of( 2014 , 2 , 11 ),
                    "ivanov@gmail.com", categories.get(1), true,
                    LocalDateTime.now(), LocalDateTime.now(), "all is okay"),
            new edu.lera.cursach.model.Tourist("2", "Ivanova", "Ivanka","Ivanivna",
                    "can't swimming", "0998765432", LocalDate.of( 2000 , 9 , 9 ),
                    "ivanova@gmail.com", categories.get(2), false,
                    LocalDateTime.now(), LocalDateTime.now(), "all is okay")

    ));

    public List<edu.lera.cursach.model.Tourist> getTourists() {
        return tourists;
    }

    public void setTourists(List<edu.lera.cursach.model.Tourist> tourists) {
        this.tourists = tourists;
    }


    private List<edu.lera.cursach.model.Amator> amators = new ArrayList<>(Arrays.asList(
            new edu.lera.cursach.model.Amator("1", "like horsing", tourists.get(0),
                    LocalDateTime.now(), LocalDateTime.now()
                    )
    ));

    public List<edu.lera.cursach.model.Amator> getAmators() {
        return amators;
    }

    public void setAmators(List<edu.lera.cursach.model.Amator> amators) {
        this.amators = amators;
    }

    private List<edu.lera.cursach.model.Captain> captains = new ArrayList<>(Arrays.asList(
            new edu.lera.cursach.model.Captain("1", "Ivanov", "Ivan","Ivanovich",
                    LocalDate.of( 2000 , 9 , 9 ),LocalDate.of( 2019 , 9 , 9 ),
                    1234.23, "ivanov@gmail.com", "0987654321",
                    LocalDateTime.now(), LocalDateTime.now(), true
            )
    ));

    public List<edu.lera.cursach.model.Captain> getCaptains() {
        return captains;
    }

    public void setCaptains(List<edu.lera.cursach.model.Captain> captains) {
        this.captains = captains;
    }

    private List<edu.lera.cursach.model.Section> sections = new ArrayList<>(Arrays.asList(
            new edu.lera.cursach.model.Section("1", "section name", "section description",
                    captains.get(0), LocalDateTime.now(), LocalDateTime.now()
            )
    ));

    public List<edu.lera.cursach.model.Section> getSections() {
        return sections;
    }

    public void setSections(List<edu.lera.cursach.model.Section> sections) {
        this.sections = sections;
    }
    private List<edu.lera.cursach.model.Coach> coaches = new ArrayList<>(Arrays.asList(
            new edu.lera.cursach.model.Coach("1", "horsing", tourists.get(0),12345.21,
                    LocalDate.of( 2019 , 9 , 9 ),
                    LocalDateTime.now(), LocalDateTime.now()
            )
    ));

    public List<edu.lera.cursach.model.Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<edu.lera.cursach.model.Coach> coaches) {
        this.coaches = coaches;
    }


    private List<edu.lera.cursach.model.Competition> competitions = new ArrayList<>(Arrays.asList(
            new edu.lera.cursach.model.Competition("1", "competition", "description",
                    sections.get(0), LocalDateTime.of(2019, 01,02,15, 00),
                    LocalDateTime.now(), LocalDateTime.now()
            )
    ));

    public List<edu.lera.cursach.model.Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<edu.lera.cursach.model.Competition> competitions) {
        this.competitions = competitions;
    }

    private List<edu.lera.cursach.model.Group> groups = new ArrayList<>(Arrays.asList(
            new edu.lera.cursach.model.Group("1", "competition", "description",
                    LocalDateTime.now(), LocalDateTime.now(), sections.get(0), coaches.get(0), captains.get(0)
            )
    ));

    public List<edu.lera.cursach.model.Group> getGroups() {
        return groups;
    }

    public void setGroups(List<edu.lera.cursach.model.Group> groups) {
        this.groups = groups;
    }


    private List<edu.lera.cursach.model.ParticipationInCompetition> participationInCompetitions = new ArrayList<>(Arrays.asList(
            new edu.lera.cursach.model.ParticipationInCompetition("1", competitions.get(0),  tourists.get(0),
                    LocalDateTime.now(), LocalDateTime.now()
            )
    ));

    public List<edu.lera.cursach.model.ParticipationInCompetition> getParticipationInCompetitions() {
        return participationInCompetitions;
    }

    public void setParticipationInCompetitions(List<edu.lera.cursach.model.ParticipationInCompetition> participationInCompetitions) {
        this.participationInCompetitions = participationInCompetitions;
    }

    private List<edu.lera.cursach.model.TourType> tourTypes = new ArrayList<>(Arrays.asList(
            new edu.lera.cursach.model.TourType("1", "type name",
                    "type description", LocalDateTime.now(), LocalDateTime.now()
            )
    ));

    public List<edu.lera.cursach.model.TourType> getTourTypes() {
        return tourTypes;
    }

    public void setTourTypes(List<edu.lera.cursach.model.TourType> tourTypes) {
        this.tourTypes = tourTypes;
    }

    private List<edu.lera.cursach.model.Tour> tours = new ArrayList<>(Arrays.asList(
            new edu.lera.cursach.model.Tour("1", "tour name", "tour description", tourists.get(0),
                    groups.get(0), 2.00, 23.23, "route", "route length",
                    LocalDateTime.of(2020, 02, 03, 12, 00),tourTypes.get(0),
                    categories.get(0),LocalDateTime.now(), LocalDateTime.now()
            )
    ));

    public List<edu.lera.cursach.model.Tour> getTours() {
        return tours;
    }

    public void setTours(List<edu.lera.cursach.model.Tour> tours) {
        this.tours = tours;
    }
    private List<edu.lera.cursach.model.PlannedTour> plannedTours = new ArrayList<>(Arrays.asList(
            new edu.lera.cursach.model.PlannedTour("1", tours.get(0), "halt schedule","break schedule",
                    LocalDateTime.now(), LocalDateTime.now()
            )
    ));

    public List<edu.lera.cursach.model.PlannedTour> getPlannedTours() {
        return plannedTours;
    }

    public void setPlannedTours(List<edu.lera.cursach.model.PlannedTour> plannedTours) {
        this.plannedTours = plannedTours;
    }

    private List<edu.lera.cursach.model.Schedule> schedules = new ArrayList<>(Arrays.asList(
            new edu.lera.cursach.model.Schedule("1", LocalDateTime.of(2020,01, 01, 12, 00),
                    2.30, "train name", "description", 00.00, groups.get(0),
                    "place number 2", LocalDateTime.now(), LocalDateTime.now()
            )
    ));

    public List<edu.lera.cursach.model.Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<edu.lera.cursach.model.Schedule> schedules) {
        this.schedules = schedules;
    }

    private List<edu.lera.cursach.model.ParticipationInTour> participationInTours = new ArrayList<>(Arrays.asList(
            new edu.lera.cursach.model.ParticipationInTour("1", tours.get(0),  tourists.get(0),
                    LocalDateTime.now(), LocalDateTime.now()
            )
    ));

    public List<edu.lera.cursach.model.ParticipationInTour> getParticipationInTours() {
        return participationInTours;
    }

    public void setParticipationInTours(List<edu.lera.cursach.model.ParticipationInTour> participationInTours) {
        this.participationInTours = participationInTours;
    }

    private List<edu.lera.cursach.model.Sportsman> sportsmen = new ArrayList<>(Arrays.asList(
            new edu.lera.cursach.model.Sportsman("1", "swimming", tourists.get(0),
                    LocalDateTime.now(), LocalDateTime.now()
            )
    ));

    public List<edu.lera.cursach.model.Sportsman> getSportsmen() {
        return sportsmen;
    }

    public void setSportsmen(List<edu.lera.cursach.model.Sportsman> sportsmen) {
        this.sportsmen = sportsmen;
    }




    private List<edu.lera.cursach.model.TouristInGroup> touristInGroups = new ArrayList<>(Arrays.asList(
            new edu.lera.cursach.model.TouristInGroup("1", groups.get(0), tourists.get(0), LocalDateTime.now(), LocalDateTime.now()
            )
    ));

    public List<edu.lera.cursach.model.TouristInGroup> getTouristInGroups() {
        return touristInGroups;
    }

    public void setTouristInGroups(List<edu.lera.cursach.model.TouristInGroup> touristInGroups) {
        this.touristInGroups = touristInGroups;
    }



    private List<edu.lera.cursach.model.UnplannedTour> unplannedTours = new ArrayList<>(Arrays.asList(
            new edu.lera.cursach.model.UnplannedTour("1", tours.get(0),
                    LocalDateTime.now(), LocalDateTime.now()
            )
    ));

    public List<edu.lera.cursach.model.UnplannedTour> getUnplannedTours() {
        return unplannedTours;
    }

    public void setUnplannedTours(List<edu.lera.cursach.model.UnplannedTour> unplannedTours) {
        this.unplannedTours = unplannedTours;
    }
}
