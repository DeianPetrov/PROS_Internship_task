package Flights.Service;

import Flights.DataStructures.FlyingPath;
import Flights.DataStructures.PossiblePaths;
import Flights.DataStructures.SingleFlypoint;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class PathFinder {

    private static class Destination {
        String to;
        int price;

        Destination(String to, int price) {
            this.to = to;
            this.price = price;
        }
    }

    private Map<String, List<Destination>> flightMap = new HashMap<>();
    private List<FlyingPath> paths = new ArrayList<>();

    public PathFinder() {
        List<SingleFlypoint> totalFlights = Arrays.asList(

                /*  //  EXAMPLE 1 INPUT //
                new SingleFlypoint("SOF","IST",10),
                new SingleFlypoint("IST","CMB",20),
                new SingleFlypoint("CMB","MLE",40)
                */
                    //  EXAMPLE 2,4 INPUT //
                new SingleFlypoint("SOF","MLE",70),
                new SingleFlypoint("SOF","LON",10),
                new SingleFlypoint("LON","MLE",20)

                /*  //EXAMPLE 3 INPUT //
                new SingleFlypoint("SOF","LON",70),
                new SingleFlypoint("SOF","NYC",10)
                */
                /*  //  EXAMPLE 5 INPUT //
                new SingleFlypoint("SOF","MLE",70),
                new SingleFlypoint("SOF","LON",10),
                new SingleFlypoint("LON","MLE",20)
                */
                );
        for(SingleFlypoint flight : totalFlights) {
            flightMap.putIfAbsent(flight.getFrom(), new ArrayList<>());
            flightMap.get(flight.getFrom()).add(new Destination(flight.getTo(), flight.getPrice()));
        }
    }

    public List<PossiblePaths> findPaths(String origin, String destination, Integer maxFlights) {
        paths.clear();
        dfs(origin, destination, new HashSet<>(), new ArrayList<>(), 0, maxFlights);
        Collections.sort(paths);
        List<PossiblePaths> possiblePaths = new ArrayList<>();
        for (FlyingPath path : paths) {
            possiblePaths.add(new PossiblePaths(path.getFlyingPath(), path.getTotalPrice()));
        }
        return possiblePaths;
    }

    private void dfs(String current, String destination, Set<String> visited, List<String> path, int cost, Integer maxFlights) {
        if (visited.contains(current) || (maxFlights != null && path.size()  -1 >= maxFlights )) {
            return;
        }

        visited.add(current);
        path.add(current);

        if (current.equals(destination)) {
            paths.add(new FlyingPath(new ArrayList<>(path), cost)); // Copy the path to avoid mutation
        } else {
            List<Destination> nextFlights = flightMap.getOrDefault(current, new ArrayList<>());
            for (Destination dest : nextFlights) {
                dfs(dest.to, destination, visited, path, cost + dest.price, maxFlights);
            }
        }

        visited.remove(current);
        path.removeLast();
    }

}

