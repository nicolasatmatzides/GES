"use strict";
const nodemailer = require("nodemailer");

function test(){
    console.log("TEST");
}

function enviarEmail(){
    const transporter = nodemailer.createTransport({
        host: "localhost",
        port: 8080,
        secure: false,
        auth: {
            user: "esthermattos@id.uff.br",
            pass: "Familycsnmrpee8"
        },
        tls: { rejectUnauthorized: false }
    });
                const mailOptions = {
        from: 'esthermattos@id.uff.br',
        to: 'silvaesthermattos@hotmail.com',
        subject: 'E-mail enviado usando Node!',
        text: 'Bem fácil, não? ;'
    };

    transporter.sendMail(mailOptions, function(error, info){
        if (error) {
            console.log("erro");
            console.log(error);
        } else {
            console.log('Email enviado: ' + info.response);
        }
    });
}