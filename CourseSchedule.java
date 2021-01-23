class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
		int[] inDegree = new int[numCourses];
		ArrayList<Integer> bfs = new ArrayList<>();
		for (int x = 0; x < numCourses; x++)
			graph[x] = new ArrayList<Integer>();
		for (int[] arr : prerequisites) {
			graph[arr[1]].add(arr[0]);
			inDegree[arr[0]]++;
		}
		for (int x = 0; x < numCourses; x++) {
			if (inDegree[x] == 0)
				bfs.add(x);
		}
		for (int x = 0; x < bfs.size(); x++) {
			for (int v : graph[bfs.get(x)]) {
				if (--inDegree[v] == 0)
					bfs.add(v);
			}
		}
		return bfs.size() == numCourses;        
    }
}
