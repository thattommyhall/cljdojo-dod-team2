(ns cljdojo-dod-team2.core
  (:require [clojure.string :as str]))


(def *num-players* 2)
(def *max-dice* 3)
(def *board-size* 2)
(def *board-hexnum* (* *board-size* *board-size*))


(def eg-board
  [[0 3] [0 3] [1 3] [1 1]])

(defn gen-board []
  eg-board)

(def player-letter
  { 0 "a"
   1 "b"})


(defn draw-board [board]
  (let [str-pair (fn [[p c]] (str p "-" c))]
    (doseq [line (map str
                      (cycle ["  " ""])
                      (map #(str/join " " %)
                           (partition *board-size* (map str-pair board))))]
      (println line))))

(defn neighbors [pos]
  (let [up (- pos *board-size*)
        down (+ pos *board-size*)]
    (for [p (concat [up down]
                    (if (not= 0 (mod pos *board-size*))
                      [(dec up) (dec pos)]
                      )
                    (if (not= 0 (mod (inc pos) *board-size*))
                          [(inc pos) (inc down)])
                    )
          :when (and (>= p 0) (< p *board-hexnum*))]
      p))
    )
  


(map neighbors (range 4))
(draw-board eg-board)