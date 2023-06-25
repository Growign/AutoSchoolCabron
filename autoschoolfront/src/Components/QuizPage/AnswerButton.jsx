import React from 'react';

const AnswerButton = ({ answer, className, disabled, onClick }) => {
    return (
        <button
            className={`answer-button ${className}`}
            disabled={disabled}
            onClick={onClick}
        >
            {answer}
        </button>
    );
};

AnswerButton.getClassName = (isSelected, isCorrect, showCorrect) => {
    switch (true) {
        case isSelected && isCorrect && showCorrect:
            return 'correct';
        case isSelected && !isCorrect:
            return 'incorrect';
        case !isSelected && isCorrect && showCorrect:
            return 'correct';
        default:
            return '';
    }
};

export default AnswerButton;
