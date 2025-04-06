package Flights.apiHandler;

import Flights.DataStructures.FlyingRequest;
import Flights.DataStructures.PossiblePaths;
import Flights.Service.PathFinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/paths")
public class FlyingController {

    private  PathFinder flightNetwork;

    public FlyingController() {
        flightNetwork= new PathFinder();
    }

    @PostMapping
    public List<PossiblePaths> getRoutes(@RequestBody FlyingRequest request) {
        return  flightNetwork.findPaths(request.getOrigin(), request.getDestination(), request.getMaxFlights());
        // to find a way to print " no route" when the list is empty in the response
    }
}