(let [prom (promise)]
  (future (println "promise: " @prom))
  (Thread/sleep 1000)
  (deliver prom "foo"))
(shutdown-agents)


