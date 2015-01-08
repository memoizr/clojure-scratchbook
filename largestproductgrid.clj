(def vect '[[1 2 3 4 4 5 1]
            [3 4 6 0 0 9 4]
            [3 4 6 0 0 9 4]
            [1 2 3 4 4 5 1]
            [3 4 6 0 0 9 4]
            [1 2 3 4 4 5 1]
            [7 4 9 8 1 7 2]])

(defn vertical [vect]
  (loop [x 0]
    (when (< x 7)
      (loop [y 0]
        (when (< y 4)
        (print (nth (nth vect y) x))
        (print (nth (nth vect (+ y 1)) x))
        (print (nth (nth vect (+ y 2)) x))
        (println (nth (nth vect (+ y 3)) x))
        (recur (inc y))))
      (println)
      (recur (inc x)))))

(defn forward [vect]
  (loop [x 0]
    (when (< x 4)
      (loop [y 0]
        (when (< y 4)
        (print (nth (nth vect y) x))
        (print (nth (nth vect (+ y 1)) (+ x 1)))
        (print (nth (nth vect (+ y 2)) (+ x 2)))
        (println (nth (nth vect (+ y 3)) (+ x 3)))
        (recur (inc y))))
      (println)
      (recur (inc x)))))

(defn backward [vect]
  (loop [x 3]
    (when (< x 7)
      (loop [y 0]
        (when (< y 4)
        (print (nth (nth vect y) x))
        (print (nth (nth vect (+ y 1)) (- x 1)))
        (print (nth (nth vect (+ y 2)) (- x 2)))
        (println (nth (nth vect (+ y 3)) (- x 3)))
        (recur (inc y))))
      (println)
      (recur (inc x)))))

(defn side [vect]
  (loop [x 0]
    (when (< x 3)
      (loop [y 0]
        (when (< y 7)
        (print (nth (nth vect y) x))
        (print (nth (nth vect y) (+ x 1)))
        (print (nth (nth vect y) (+ x 2)))
        (println (nth (nth vect y) (+ x 3)))
        (recur (inc y))))
      (println)
      (recur (inc x)))))

;=========================================================
;=========================================================
;=========================================================
;=========================================================
;=========================================================

(defn vertical [vect]
    (let [lst ()]
    (loop [x 0 lsta ()]
      (when (< x 7)
          (loop [y 0 lsts ()]
            (if (< y 4)
              (do
                (def a (nth (nth vect y) x))
                (def b (nth (nth vect (+ y 1)) x))
                (def c (nth (nth vect (+ y 2)) x))
                (def d (nth (nth vect (+ y 3)) x))
                (def result (reduce * (list a b c d)))
                (recur (inc y) (conj lsts result)))
              (println (concat lsta lsts))))
        (recur (inc x) lsta)))))

(defn forward [vect]
  (loop [x 0]
    (when (< x 4)
      (loop [y 0]
        (when (< y 4)
        (print (nth (nth vect y) x))
        (print (nth (nth vect (+ y 1)) (+ x 1)))
        (print (nth (nth vect (+ y 2)) (+ x 2)))
        (println (nth (nth vect (+ y 3)) (+ x 3)))
        (recur (inc y))))
      (println)
      (recur (inc x)))))

(defn backward [vect]
  (loop [x 3]
    (when (< x 7)
      (loop [y 0]
        (when (< y 4)
        (print (nth (nth vect y) x))
        (print (nth (nth vect (+ y 1)) (- x 1)))
        (print (nth (nth vect (+ y 2)) (- x 2)))
        (println (nth (nth vect (+ y 3)) (- x 3)))
        (recur (inc y))))
      (println)
      (recur (inc x)))))

(defn side [vect]
  (loop [x 0]
    (when (< x 3)
      (loop [y 0]
        (when (< y 7)
        (print (nth (nth vect y) x))
        (print (nth (nth vect y) (+ x 1)))
        (print (nth (nth vect y) (+ x 2)))
        (println (nth (nth vect y) (+ x 3)))
        (recur (inc y))))
      (println)
      (recur (inc x)))))

(println (vertical vect))
;(forward vect)
;(backward vect)
;(side vect)
