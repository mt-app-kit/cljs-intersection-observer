
(ns intersection-observer.api
    (:require [intersection-observer.side-effects :as side-effects]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; intersection-observer.side-effects
(def setup-observer!  side-effects/setup-observer!)
(def remove-observer! side-effects/remove-observer!)
