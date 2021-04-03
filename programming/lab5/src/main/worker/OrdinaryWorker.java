package main.worker;

import exeptions.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class OrdinaryWorker extends DefaultWorker{
    //id уникальный и генерится автоматически
    //name не может быть null, Строка не может быть пустой
    //coordinates не может быть null
    //creationDate не может быть null, Значение этого поля должно генерироваться автоматически
    //salary не может быть null, Значение поля должно быть больше 0
    //endDate может быть null
    //position не может быть null
    //status не может быть null
    //organization может быть null

    private static long lastId;

    public OrdinaryWorker(){
        this.id = ++lastId;
        this.creationDate = LocalDateTime.now();
    }

    private OrdinaryWorker(OrdinaryWorker ordinaryWorker){

    }

    public OrdinaryWorker(String name, Coordinates coordinates, Double salary,
                          ZonedDateTime endDate, Position position,
                          Status status, Organization organization){

        Worker constructWorker = new OrdinaryWorker();

        constructWorker.setName(name);
        constructWorker.setCoordinates(coordinates);
        constructWorker.setSalary(salary);
        constructWorker.setEndDate(endDate);
        constructWorker.setPosition(position);
        constructWorker.setStatus(status);
        constructWorker.setOrganization(organization);

        this.name = constructWorker.getName();
        this.coordinates = constructWorker.getCoordinates();
        this.salary = constructWorker.getSalary();
        this.endDate = constructWorker.getEndDate();
        this.position = constructWorker.getPosition();
        this.status = constructWorker.getStatus();
        this.organization = constructWorker.getOrganization();
    }

    @Override
    public void setName(String name){
        if (name == null || (name.length() <= 0)) {
            throw new InvalidNameException();
        }
        this.name = name;
    }

    @Override
    public void setCoordinates(Coordinates coordinates){
        if(coordinates == null) throw new InvalidCoordinatesException();
        this.coordinates = coordinates;
    }

    @Override
    public void setSalary(Double salary){
        if(salary == null || salary <= 0) throw new InvalidWorkerFieldException("Incorrect salary");
        this.salary = salary;
    }

    @Override
    public void setPosition(Position position){
        if(position == null){
            throw new InvalidPositionException();
        }
        this.position = position;
    }

    @Override
    public void setStatus(Status status){
        if(status == null) {
            throw new InvalidStatusException();
        }
        this.status = status;
    }
}
