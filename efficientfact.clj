(defn factorial ([n] (factorial n 1)) ([n acc] (if (= n 0) acc (recur (dec n) (*' acc n)))))


(print (factorial 340))
