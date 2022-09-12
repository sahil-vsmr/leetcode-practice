class LogAggregator {
    
    Map<Integer, List<Log>> machineMap = new HashMap();
    Map<Integer, List<Log>> serviceMap = new HashMap();
    int numberOfMachines;
    int numberOfServices;
    
    class Log {
        int id;
        String message;
        
        Log (int id, String message) {
            this.id = id;
            this.message = message;
        }
    }

    public LogAggregator(int machines, int services) {
        this.numberOfMachines = machines;
        this.numberOfServices = services;
    }
    
    public void pushLog(int logId, int machineId, int serviceId, String message) {
        Log log = new Log(logId, message);
        
        if (!machineMap.containsKey(machineId)) {
            List<Log> list = new ArrayList<>();
            list.add(log);
            machineMap.put(machineId, list);
        } else {
            List<Log> logs = machineMap.get(machineId);
            logs.add(log);
            machineMap.put(machineId, logs);
        }
        
        if (!serviceMap.containsKey(serviceId)) {
            List<Log> list = new ArrayList<>();
            list.add(log);
            serviceMap.put(serviceId, list);
        } else {
            List<Log> logs = serviceMap.get(serviceId);
            logs.add(log);
            serviceMap.put(serviceId, logs);
        }
        
        
    }
    
    public List<Integer> getLogsFromMachine(int machineId) {
        List<Integer> result = new ArrayList<>();
        
        if (machineMap.containsKey(machineId)) {
            List<Log> logs = machineMap.get(machineId);
            for (Log log: logs) {
                result.add(log.id);
            }
        }
        return result;
    }
    
    public List<Integer> getLogsOfService(int serviceId) {
        List<Integer> result = new ArrayList<>();
        
        if (serviceMap.containsKey(serviceId)) {
            List<Log> logs = serviceMap.get(serviceId);
            for (Log log: logs) {
                result.add(log.id);
            }
        }
        return result;
    }
    
    public List<String> search(int serviceId, String searchString) {
        List<String> result = new ArrayList<>();
        
        if (serviceMap.containsKey(serviceId)) {
            List<Log> logs = serviceMap.get(serviceId);
            for (Log log: logs) {
                if (log.message.contains(searchString)) {
                    result.add(log.message);
                }
            }
        }
        return result;
    }
}

/**
 * Your LogAggregator object will be instantiated and called as such:
 * LogAggregator obj = new LogAggregator(machines, services);
 * obj.pushLog(logId,machineId,serviceId,message);
 * List<Integer> param_2 = obj.getLogsFromMachine(machineId);
 * List<Integer> param_3 = obj.getLogsOfService(serviceId);
 * List<String> param_4 = obj.search(serviceId,searchString);
 */